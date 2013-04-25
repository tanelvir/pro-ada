package bibtex.gens;

import bibtex.gen.BibtexGenerator;
import bibtex.gen.BibtexPrinter;
import bibtex.gen.TextGenerator;
import java.io.PrintWriter;

public class BookGenerator extends BibtexPrinter implements TextGenerator {

    public BookGenerator(PrintWriter filuPrinter, PrintWriter sivuPrinter, BibtexGenerator bg) {
        super(filuPrinter, sivuPrinter, bg);
    }

    @Override
    public void generoi() throws Exception {
        printtaaTyyppi(bg.Tyyppi);
        printtaaEiPakollinen("author", bg.Author);
        printtaaEiPakollinen("editor", bg.Editor);
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
        printtaaAaltosulku();
        suljePrintterit();
    }
}
