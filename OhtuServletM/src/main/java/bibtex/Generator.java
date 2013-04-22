package bibtex;

import bibtex.gen.BibtexGenerator;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Generator extends HttpServlet {
    
    TyyppiArrayList tAL = new TyyppiArrayList();
    PrintWriter out;
    
    private String[] muunnaParametrit(String tyyppi, Map<String,String[]> parameterMap) {//k
        
        
	Set<Map.Entry<String,String[]>> parameterSet = parameterMap.entrySet();
        ArrayList<String> parametrit = new ArrayList<String>();
        parametrit.add(tyyppi);
        for (Entry<String, String[]> parameter : parameterSet) {
            if (parameter.getValue()[0].equals("")) continue;
            if (parameter.getKey().equals("tyyppi")) continue;
            parametrit.add(parameter.getKey()+"@"+parameter.getValue()[0]);
            System.out.println(parameter.getKey()+"@"+parameter.getValue()[0]);
        }
        String[] tulos = new String[parametrit.size()];
        return parametrit.toArray(tulos);
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //request.getreq
        String[] parametrit = muunnaParametrit(request.getParameter("tyyppi"), request.getParameterMap());
        out = response.getWriter();
        
        //jos ID puuttuu tai on jo käytössä
        //syötä ID uudelleen eli palaa osittain täytettyyn lomakkeeseen
        if (!tAL.add(parametrit)) {
            out.println("ID PUUTTUU TAI ID JO KÄYTÖSSÄ!");
            return;
        }
        StringWriter joenTeksti = new StringWriter();
        PrintWriter joenTeksti2 = new PrintWriter(joenTeksti);
        try {
            BibtexGenerator bibi = new BibtexGenerator(tAL, joenTeksti2, false);

            } catch (Exception ex) {
                out.println("pakollinen kenttä puuttuu!");
                tAL.remove(parametrit);
                return;
            }
        try {
            out.println("<!DOCTYPE html>\n" +
"<!-- Aloitussivu, jolta käyttäjä valitsee haluamansa lomakepohjan !-->\n" +
"<html>\n" +
"    <head>\n" +
"        <title>BibTeX Generator</title>\n" +
"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
"\n" +
"        <script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js\"></script>\n" +
"        <script type=\"text/javascript\">\n" +
"            \n" +
"            \n" +
"            function muutos(){\n" +
"                var value = $('#theSelect option:selected').attr('value');\n" +
"                var completeUrl = value+'.html';\n" +
"                $(\"#myform\").attr(\"action\", completeUrl);\n" +
"            }\n" +
"\n" +
"        </script>\n" +
"\n" +
"    </head>\n" +
"    <body>\n" +
"        <h1>\n" +
"            BibTeX Generator\n" +
"        </h1>\n" +
"\n" +
"        <!-- Pudotusvalikko lomakkeen valitsemiseksi !-->\n" +
"        <div>\n" +
"            <br>\n" +
"            <p>Choose a form type:</p>\n" +
"            <Form id=\"myform\" action=\"article.html\" Method =\"post\" accept-charset=\"utf-8\">\n" +
"\n" +
"                <select id=\"theSelect\" onchange=\"muutos()\">\n" +
"                    <option value=\"article\">Article</option>\n" +
"                    <option value=\"book\">Book</option>\n" +
"                    <option value=\"booklet\">Booklet</option>\n" +
"                    <option value=\"conference\">Conference</option>\n" +
"                    <option value=\"inbook\">Inbook</option>\n" +
"                    <option value=\"incollection\">Incollection</option>\n" +
"                    <option value=\"inproceedings\">Inproceedings</option>\n" +
"                    <option value=\"manual\">Manual</option>\n" +
"                    <option value=\"mastersthesis\">Master's Thesis</option>\n" +
"                    <option value=\"misc\">Misc</option>\n" +
"                    <option value=\"phdthesis\">Ph.D. Thesis</option>\n" +
"                    <option value=\"proceedings\">Proceedings</option>\n" +
"                    <option value=\"techreport\">Techreport</option>\n" +
"                    <option value=\"unpublished\">Unpublished</option>\n" +
"                </select>\n" +
"\n" +
"                <Input type = 'Submit' Name = 'submit' Value = 'Choose'>\n" +
"\n" +
"            </form>"
                    + "<br><br>\n" +
"        </div>\n" +

"    </body>\n" +
"</html>");
            
        printtaaAlkutag();
            
        out.println(joenTeksti.toString());
        
        printtaaLopputag();
        
        } finally {            
            out.close();
        }
    }
    
    public void printtaaAlkutag() {
        out.println("<form name=\"bibtex\">\n"
                    + "            <textarea name=\"bibtex\" rows=\"40\" cols=\"80\">");
    }
    
    public void printtaaLopputag() {
        out.println("</textarea>\n"
                    + "        </form>");
    }

//    public void printtaaPolku() {
//        out.println("POLKU : " + bg.file.getAbsolutePath());
//        out.println("<a href=\"" + bg.file.getAbsolutePath() + "\">Bibtex-tiedoston latauslinkki</a>");
//        //<a href="default.asp">HTML Tutorial</a>
//    }

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