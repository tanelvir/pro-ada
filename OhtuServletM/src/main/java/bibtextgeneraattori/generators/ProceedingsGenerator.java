package bibtextgeneraattori.generators;

import bibtexgeneraattori.BibtexGenerator;
import bibtexgeneraattori.BibtexPrinter;
import bibtexgeneraattori.TextGenerator;
import java.io.PrintWriter;

public class ProceedingsGenerator extends BibtexPrinter implements TextGenerator {

    public ProceedingsGenerator(PrintWriter filuPrinter, PrintWriter sivuPrinter, BibtexGenerator bg) {
        super(filuPrinter, sivuPrinter, bg);
    }

    @Override
    public void generoi() {
        sivuPrinter.println("proceedings@{" + bg.Tyyppi + ",");
        filuPrinter.println("inproceedings@{" + bg.Tyyppi + ",");
        printtaa("title", bg.Title);
        printtaa("year", bg.Year);
        printtaaEiPakollinen("editor", bg.Editor);
        printtaaEiPakollinen("volume", bg.Volume);
        printtaaEiPakollinen("number", bg.Number);
        printtaaEiPakollinen("series", bg.Series);
        printtaaEiPakollinen("address", bg.Address);
        printtaaEiPakollinen("month", bg.Month);
        printtaaEiPakollinen("publisher", bg.Publisher);
        printtaaEiPakollinen("organization", bg.Organization);
        printtaaEiPakollinen("note", bg.Note);
        printtaaEiPakollinen("key", bg.Key);
        sivuPrinter.println("}");
        if (bg.suljetaanko) {
            sivuPrinter.close();
        }
    }
}