package bibtextgeneraattori.generators;

import bibtexgeneraattori.BibtexGenerator;
import bibtexgeneraattori.BibtexPrinter;
import bibtexgeneraattori.TextGenerator;
import java.io.PrintWriter;

public class ArticleGenerator extends BibtexPrinter implements TextGenerator {

    public ArticleGenerator(PrintWriter filuPrinter, PrintWriter sivuPrinter, BibtexGenerator bg) {
        super(filuPrinter, sivuPrinter, bg);
    }

    @Override
    public void generoi() {
        printtaaAlkutag();
        printtaaTyyppi(bg.Tyyppi);
        printtaa("author", bg.Author);
        printtaa("title", bg.Title);
        printtaa("journal", bg.Journal);
        printtaa("year", bg.Year);
        printtaaEiPakollinen("volume", bg.Volume);
        printtaaEiPakollinen("number", bg.Number);
        printtaaEiPakollinen("pages", bg.Series);
        printtaaEiPakollinen("month", bg.Month);
        printtaaEiPakollinen("note", bg.Edition);
        printtaaEiPakollinen("key", bg.Month);
        printtaaAaltosulku();
        printtaaLopputag();
        printtaaPolku();
        suljePrintterit();
    }
}
