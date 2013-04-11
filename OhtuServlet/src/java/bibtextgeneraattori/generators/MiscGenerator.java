package bibtextgeneraattori.generators;

import bibtexgeneraattori.BibtexGenerator;
import bibtexgeneraattori.BibtexPrinter;
import bibtexgeneraattori.TextGenerator;
import java.io.PrintWriter;

public class MiscGenerator extends BibtexPrinter implements TextGenerator {

    public MiscGenerator(PrintWriter filuPrinter, PrintWriter sivuPrinter, BibtexGenerator bg) {
        super(filuPrinter, sivuPrinter, bg);
    }

    @Override
    public void generoi() {
        sivuPrinter.println("@misc{" + bg.Tyyppi + ",");
        filuPrinter.println("inproceedings@{" + bg.Tyyppi + ",");
        printtaaEiPakollinen("author", bg.Author);
        printtaaEiPakollinen("title", bg.Title);
        printtaaEiPakollinen("howpublished", bg.Howpublished);
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