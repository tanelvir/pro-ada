package bibtex.gen;

import java.io.PrintWriter;

public class BibtexPrinter {

    public PrintWriter sivuPrinter;
    public PrintWriter filuPrinter;
    public BibtexGenerator bg;

    public BibtexPrinter(PrintWriter filuPrinter, PrintWriter sivuPrinter, BibtexGenerator bg) {
        this.sivuPrinter = sivuPrinter;
        this.filuPrinter = filuPrinter;
        this.bg = bg;

    }
    
    public void printtaaAlkutag() {
        if (sivuPrinter != null) {
            sivuPrinter.println("<form name=\"bibtex\">\n" +
"            <textarea name=\"bibtex\" rows=\"40\" cols=\"80\">");
        }
    }
    
    public void printtaaLopputag() {
        if (sivuPrinter != null) {
            sivuPrinter.println("</textarea>\n" +
"        </form>");
        }
    }

    //valinnaiset
    public void printtaaEiPakollinen(String nimi, String mita) {
        if (!mita.isEmpty()) {
            printtaa(nimi, mita);
        }
    }
    
    //pakolliset (ja valinnaiset)
    public void printtaa(String nimi, String mita) {
        if (sivuPrinter != null) {
            sivuPrinter.println(nimi + " = {" + mita + "},");
        }
        filuPrinter.println(nimi + " = {" + mita + "},");
    }
    
    //alkuun
    public void printtaaTyyppi(String tyyppi) {
        if (sivuPrinter != null) {
            sivuPrinter.println("@" + tyyppi + " {" + tyyppi + ",");
        }
        filuPrinter.println("@" + tyyppi + " {" + tyyppi + ",");
    }
    
    //loppuun
    public void printtaaAaltosulku() {
        if (sivuPrinter != null) {
            sivuPrinter.println("}");
        }
        filuPrinter.println("}");
    }
    
    public void printtaaPolku() {
        if (sivuPrinter != null) {
            sivuPrinter.println("POLKU : " + bg.file.getAbsolutePath());
            sivuPrinter.println("<a href=\"" + bg.file.getAbsolutePath() + "\">Bibtex-tiedoston latauslinkki</a>");
            //<a href="default.asp">HTML Tutorial</a>
        }
    }

    public void suljePrintterit() {
        if (bg.suljetaanko) {
            sivuPrinter.close();
        }
        filuPrinter.close();
    }
}
