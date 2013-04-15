package bibtex.gens;

import bibtex.gen.BibtexGenerator;
import bibtex.gen.BibtexPrinter;
import bibtex.gen.TextGenerator;
import java.io.PrintWriter;

public class ManualGenerator extends BibtexPrinter implements TextGenerator {

    public ManualGenerator(PrintWriter filuPrinter, PrintWriter sivuPrinter, BibtexGenerator bg) {
        super(filuPrinter, sivuPrinter, bg);
    }

    @Override
    public void generoi() {
        sivuPrinter.println("@manual{" + bg.Tyyppi + ",");
        filuPrinter.println("inproceedings@{" + bg.Tyyppi + ",");
        printtaa("title", bg.Title);
        printtaaEiPakollinen("author", bg.Author);
        printtaaEiPakollinen("organization", bg.Organization);
        printtaaEiPakollinen("address", bg.Address);
        printtaaEiPakollinen("edition", bg.Edition);
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