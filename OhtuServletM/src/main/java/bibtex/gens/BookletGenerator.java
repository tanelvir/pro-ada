package bibtex.gens;

import bibtex.gen.BibtexGenerator;
import bibtex.gen.BibtexPrinter;
import bibtex.gen.TextGenerator;
import java.io.PrintWriter;

public class BookletGenerator extends BibtexPrinter implements TextGenerator {

    public BookletGenerator(PrintWriter filuPrinter, PrintWriter sivuPrinter, BibtexGenerator bg) {
        super(filuPrinter, sivuPrinter, bg);
    }

    @Override
    public void generoi() throws Exception {
        sivuPrinter.println("@booklet{" + bg.Tyyppi + ",");
        filuPrinter.println("inproceedings@{" + bg.Tyyppi + ",");
        printtaa("title", bg.Title);
        printtaa("publisher", bg.Publisher);
        printtaaEiPakollinen("author", bg.Author);
        printtaaEiPakollinen("howpublished", bg.Howpublished);
        printtaaEiPakollinen("address", bg.Address);
        printtaaEiPakollinen("month", bg.Month);
        printtaaEiPakollinen("year", bg.Year);
        printtaaEiPakollinen("note", bg.Note);
        printtaaEiPakollinen("key", bg.Key);
        sivuPrinter.println("}");
        if (bg.suljetaanko) {
            sivuPrinter.close();
        }
    }
}