package bibtex;

import bibtex.gen.BibtexGenerator;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Generator extends HttpServlet {

    TyyppiArrayList tyyppiArrayList = new TyyppiArrayList();
    PrintWriter out;
    StringWriter bibtexi;
    BibtexGenerator bibi;

    private String[] muunnaParametrit(String tyyppi, Map<String, String[]> parameterMap) {//k
        Set<Map.Entry<String, String[]>> parameterSet = parameterMap.entrySet();
        ArrayList<String> parametrit = new ArrayList<String>();
        parametrit.add(tyyppi);
        for (Entry<String, String[]> parameter : parameterSet) {
            if (parameter.getValue()[0].equals("")) {
                continue;
            }
            if (parameter.getKey().equals("tyyppi")) {
                continue;
            }
            String value = parameter.getValue()[0];
            //parameter.setValue(new String[] {parameter.getValue()[0].replaceAll(tyyppi, tyyppi));
            parametrit.add(parameter.getKey() + "@" + value);
            System.out.println(parameter.getKey() + "@" + value);
        }
        String[] tulos = new String[parametrit.size()];
        return parametrit.toArray(tulos);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        //request.getreq
        String[] parametrit = muunnaParametrit(request.getParameter("tyyppi"), request.getParameterMap());
        out = response.getWriter();

        //jos ID puuttuu tai on jo käytössä
        //syötä ID uudelleen eli palaa osittain täytettyyn lomakkeeseen
        if (!tyyppiArrayList.add(parametrit)) {
            out.println("ID on jo käytössä!");
            return;
        }
        bibtexi = new StringWriter();
        PrintWriter sivuPrinter = new PrintWriter(bibtexi);
        try {
            bibi = new BibtexGenerator(tyyppiArrayList, sivuPrinter, false);

        } catch (Exception ex) {
            out.println("pakollinen kenttä puuttuu!");
            System.out.println("pakollinen kenttä puuttui. poisto = " + tyyppiArrayList.remove(tyyppiArrayList.size() - 1));
            return;
        }
        try {
            printtaaHtml();
        } finally {
            out.close();
        }
    }

    private void printtaaHtml() throws IOException {
        HtmlContents c = new HtmlContents();
        out.println(c.CONTENT);

        printtaaAlkutag();

        out.println(bibtexi.toString());

        printtaaLopputag();

        printtaaPolku();
    }

    private void printtaaAlkutag() {
        out.println("<form name=\"bibtex\">\n"
                + "            <textarea name=\"bibtex\" rows=\"40\" cols=\"80\">");
    }

    private void printtaaLopputag() {
        out.println("</textarea>\n"
                + "        </form>");
    }

    private void printtaaPolku() {
        out.println("POLKU : " + bibi.file.getAbsolutePath());
        out.println("<a href=\"" + bibi.file.getAbsolutePath() + "\">Bibtex-tiedoston latauslinkki</a>");
        //<a href="default.asp">HTML Tutorial</a>
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
