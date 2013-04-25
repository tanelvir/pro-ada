
package bibtex;

public class HtmlContents {
    
    public final String CONTENT = "<!DOCTYPE html>\n" +
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
"                    <option value=\"inproceedings\">Inproceedings</option>\n" +
"                </select>\n" +
"\n" +
"                <Input type = 'Submit' Name = 'submit' Value = 'Choose'>\n" +
"\n" +
"            </form>"
                    + "<br><br>\n" +
"        </div>\n" +

"    </body>\n" +
"</html>";  
}
