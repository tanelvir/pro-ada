package bibtex;

import .*;
import bibtex.gen.BibtexGenerator;
import java.io.IOException;
import java.io.PrintWriter;
//import java.util.Collection;
//import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Inproceedings extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //Map<String, String[]> params = request.getParameterMap();
        
        String author = request.getParameter("author");
        String title = request.getParameter("title");
        String booktitle = request.getParameter("booktitle");
        String year = request.getParameter("year");
        String[] parametrit = new String[] {"author@"+author, "title@"+title, "booktitle@"+booktitle, "year@"+year};
        
        PrintWriter out = response.getWriter();
        BibtexGenerator bibi = new BibtexGenerator("inproceedings", parametrit, out);
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
            
            //bibtexin generointi
            bibi.generoiBibtext();
            
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