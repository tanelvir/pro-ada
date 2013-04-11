package bibtexgeneraattori;

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

    public void printtaaEiPakollinen(String nimi, String mita) {
        if (!mita.isEmpty()) {
            printtaa(nimi, mita);
        }
    }

    public void printtaa(String nimi, String mita) {
        if (sivuPrinter != null) {
            sivuPrinter.println(nimi + " = {" + mita + "},");
        }
        filuPrinter.println(nimi + " = {" + mita + "},");
    }

    public void printtaaTyyppi(String tyyppi) {
        if (sivuPrinter != null) {
            sivuPrinter.println(tyyppi + "@{" + tyyppi + ".");
        }
        filuPrinter.println(tyyppi + "@{" + tyyppi + ".");
    }

    public void printtaaAaltosulku() {
        if (sivuPrinter != null) {
            sivuPrinter.println("}");
        }
        filuPrinter.println("}");
    }

    public void suljePrintterit() {
        if (bg.suljetaanko) {
            sivuPrinter.close();
        }
        filuPrinter.close();
    }
}
