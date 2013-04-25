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
    //valinnaiset
    public void printtaaEiPakollinen(String nimi, String mita) {
        if (!mita.isEmpty()) {
            mita = poistaÄäkköset(mita);
            if (sivuPrinter != null) {
                sivuPrinter.println(nimi + " = {" + mita + "},");
            }
            filuPrinter.println(nimi + " = {" + mita + "},");
        }
    }

    //pakolliset
    public void printtaa(String nimi, String mita) throws Exception {
        if (mita.equals("")) {
            throw new Exception("PakollinenKenttaPuuttuu");
        }
        mita = poistaÄäkköset(mita);
        if (sivuPrinter != null) {
            sivuPrinter.println(nimi + " = {" + mita + "},");
        }
        filuPrinter.println(nimi + " = {" + mita + "},");
    }

    //alkuun
    public void printtaaTyyppi(String tyyppi) {
        if (sivuPrinter != null) {
            sivuPrinter.println("@" + tyyppi + "{" + bg.ID + ",");
        }
        filuPrinter.println("@" + tyyppi + "{" + bg.ID + ",");
    }

    //loppuun
    public void printtaaAaltosulku() {
        if (sivuPrinter != null) {
            sivuPrinter.println("}");
        }
        filuPrinter.println("}");
    }

    public void suljePrintterit() {
        if (bg.suljetaanko) {
            filuPrinter.close();
        }
    }

    private String poistaÄäkköset(String teksti) {
        String a = java.util.regex.Matcher.quoteReplacement("\\\"");
        String tulos = teksti.replaceAll("ä", a + "{a}").replaceAll("Ä", a + "{A}");
        tulos = tulos.replaceAll("ö", a + "{o}").replaceAll("Ö", a + "{O}");
        return tulos;
    }
}
