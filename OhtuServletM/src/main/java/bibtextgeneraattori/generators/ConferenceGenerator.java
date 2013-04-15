package bibtextgeneraattori.generators;

import bibtexgeneraattori.BibtexGenerator;
import bibtexgeneraattori.BibtexPrinter;
import bibtexgeneraattori.TextGenerator;
import java.io.PrintWriter;

public class ConferenceGenerator extends BibtexPrinter implements TextGenerator {

    public ConferenceGenerator(PrintWriter filuPrinter, PrintWriter sivuPrinter, BibtexGenerator bg) {
        super(filuPrinter, sivuPrinter, bg);
    }

    @Override
    public void generoi() {
        sivuPrinter.println("conference@{" + bg.Tyyppi + ",");
        filuPrinter.println("inproceedings@{" + bg.Tyyppi + ",");
        printtaa("author", bg.Author);
        printtaa("title", bg.Title);
        printtaa("booktitle", bg.Year);
        printtaa("year", bg.Year);
        printtaaEiPakollinen("editor", bg.Editor);
        printtaaEiPakollinen("volume", bg.Volume);
        printtaaEiPakollinen("number", bg.Number);
        printtaaEiPakollinen("series", bg.Series);
        printtaaEiPakollinen("pages", bg.Pages);
        printtaaEiPakollinen("address", bg.Address);
        printtaaEiPakollinen("month", bg.Month);
        printtaaEiPakollinen("organization", bg.Organization);
        printtaaEiPakollinen("publisher", bg.Publisher);
        printtaaEiPakollinen("note", bg.Note);
        printtaaEiPakollinen("key", bg.Key);
        sivuPrinter.println("}");
        if (bg.suljetaanko) {
            sivuPrinter.close();
        }
    }
}