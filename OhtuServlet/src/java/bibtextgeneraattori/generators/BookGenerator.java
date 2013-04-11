package bibtextgeneraattori.generators;

import bibtexgeneraattori.BibtexGenerator;
import bibtexgeneraattori.BibtexPrinter;
import bibtexgeneraattori.TextGenerator;
import java.io.PrintWriter;

public class BookGenerator extends BibtexPrinter implements TextGenerator {

    public BookGenerator(PrintWriter filuPrinter, PrintWriter sivuPrinter, BibtexGenerator bg) {
        super(filuPrinter, sivuPrinter, bg);
    }

    @Override
    public void generoi() {
        sivuPrinter.println("@book{" + bg.Tyyppi + ",");
        filuPrinter.println("inproceedings@{" + bg.Tyyppi + ",");
        printtaa("author", bg.Author);
        printtaa("title", bg.Title);
        printtaa("year", bg.Year);
        printtaa("publisher", bg.Publisher);
        printtaaEiPakollinen("volume", bg.Volume);
        printtaaEiPakollinen("number", bg.Number);
        printtaaEiPakollinen("series", bg.Series);
        printtaaEiPakollinen("address", bg.Address);
        printtaaEiPakollinen("edition", bg.Edition);
        printtaaEiPakollinen("month", bg.Month);
        printtaaEiPakollinen("note", bg.Note);
        printtaaEiPakollinen("key", bg.Key);
        sivuPrinter.println("}");
        if (bg.suljetaanko) {
            sivuPrinter.close();
        }
    }
}
