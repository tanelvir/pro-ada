package bibtextgeneraattori.generators;

import bibtexgeneraattori.BibtexGenerator;
import bibtexgeneraattori.BibtexPrinter;
import bibtexgeneraattori.TextGenerator;
import java.io.PrintWriter;

public class InproceedingsGenerator extends BibtexPrinter implements TextGenerator {


    public InproceedingsGenerator(PrintWriter filuPrinter, PrintWriter sivuPrinter, BibtexGenerator bg) {
        super(filuPrinter, sivuPrinter, bg);
    }

    @Override
    public void generoi() {
        printtaaAlkutag();
        printtaaTyyppi(bg.Tyyppi);
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
        printtaaAaltosulku();
        printtaaLopputag();
        printtaaPolku();
        suljePrintterit();
    }
}