package bibtex.gens;

import bibtex.gen.BibtexGenerator;
import bibtex.gen.BibtexPrinter;
import bibtex.gen.TextGenerator;
import java.io.PrintWriter;

public class UnpublishedGenerator extends BibtexPrinter implements TextGenerator {

    public UnpublishedGenerator(PrintWriter filuPrinter, PrintWriter sivuPrinter, BibtexGenerator bg) {
        super(filuPrinter, sivuPrinter, bg);
    }

    @Override
    public void generoi() {
        sivuPrinter.println("unpublished@{" + bg.Tyyppi + ",");
        filuPrinter.println("inproceedings@{" + bg.Tyyppi + ",");
        printtaa("author", bg.Author);
        printtaa("title", bg.Title);
        printtaa("note", bg.Note);
        printtaaEiPakollinen("month", bg.Month);
        printtaaEiPakollinen("year", bg.Year);
        printtaaEiPakollinen("key", bg.Key);
        sivuPrinter.println("}");
        if (bg.suljetaanko) {
            sivuPrinter.close();
        }
    }
}