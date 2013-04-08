package bibtexgeneraattori;

import java.io.PrintWriter;

public class BibtexPrinter {

    public PrintWriter sivuPrinter;
    public PrintWriter filuPrinter;
    public BibtexGenerator bg;
    
    public BibtexPrinter(PrintWriter sivuPrinter, PrintWriter filuPrinter, BibtexGenerator bg) {
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
        sivuPrinter.println(nimi + " = {" + mita + "},");
        filuPrinter.println(nimi + " = {" + mita + "},");
    }
}
