package bibtextgeneraattori.generators;

import bibtexgeneraattori.BibtexGenerator;
import bibtexgeneraattori.TextGenerator;
import java.io.PrintWriter;

public class BookGenerator implements TextGenerator {

    private PrintWriter out;
    private BibtexGenerator bg;

    public BookGenerator(PrintWriter out, BibtexGenerator bg) {
        this.out = out;
        this.bg = bg;
    }

    @Override
    public void generoi() {
        out.println("@book{" + bg.Tyyppi + ",");
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
        out.println("}");
        out.close();
    }

    private void printtaaEiPakollinen(String nimi, String mita) {
        if (!mita.isEmpty()) {
            printtaa(nimi, mita);
        }
    }

    private void printtaa(String nimi, String mita) {
        out.println(nimi + " = {" + mita + "},");
    }
}
