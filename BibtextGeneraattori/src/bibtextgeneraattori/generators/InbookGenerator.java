package bibtextgeneraattori.generators;

import bibtextgeneraattori.BibtextGenerator;
import bibtextgeneraattori.TextGenerator;
import java.io.PrintWriter;

public class InbookGenerator implements TextGenerator {

    private PrintWriter out;
    private BibtextGenerator bg;

    public InbookGenerator(PrintWriter out, BibtextGenerator bg) {
        this.out = out;
        this.bg = bg;
    }

    @Override
    public void generoi() {
        out.println("@inbook{" + bg.Tunnus + ",");
        printtaa("author", bg.Author);
        printtaa("title", bg.Title);
        printtaa("chapter", bg.Chapter);
        printtaa("publisher", bg.Publisher);
        printtaa("year", bg.Year);
        printtaaEiPakollinen("volume", bg.Volume);
        printtaaEiPakollinen("number", bg.Number);
        printtaaEiPakollinen("series", bg.Series);
        printtaaEiPakollinen("type", bg.Type);
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
