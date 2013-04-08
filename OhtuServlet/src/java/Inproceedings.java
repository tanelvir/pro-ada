/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import bibtexgeneraattori.BibtexGenerator;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Antti
 */
public class Inproceedings extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Map<String, String[]> params = request.getParameterMap();
        
        String author = request.getParameter("author");
        String title = request.getParameter("title");
        String booktitle = request.getParameter("book title");
        String year = request.getParameter("year");
        String[] parametrit = new String[] {"author@"+author, "title@"+title, "booktitle@"+booktitle, "year@"+year};
        
        PrintWriter out = response.getWriter();
        BibtexGenerator bibi = new BibtexGenerator("inproceedings", parametrit, out);
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
//            out.println("<title>Servlet Inproceedings</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println();
            bibi.generoiBibtext();
//            for (Map.Entry<String, String[]> param : params.entrySet()) {
//                out.println("key: "+param.getKey());
//                out.println("<br>");
//                out.println("value(s): ");
//                for (String value : param.getValue()) {
//                    out.print(value+", ");
//                }
//                out.println("<br>----<br>");
//            }
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
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