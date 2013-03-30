package bibtextgeneraattori.generators;

import bibtextgeneraattori.BibtextGenerator;
import bibtextgeneraattori.TextGenerator;
import java.io.PrintWriter;

public class BookletGenerator implements TextGenerator {

    private PrintWriter out;
    private BibtextGenerator bg;

    public BookletGenerator(PrintWriter out, BibtextGenerator bg) {
        this.out = out;
        this.bg = bg;
    }

    @Override
    public void generoi() {
        out.println("@booklet{" + bg.Tunnus + ",");
        printtaa("title", bg.Title);
        printtaa("publisher", bg.Publisher);
        printtaaEiPakollinen("author", bg.Author);
        printtaaEiPakollinen("howpublished", bg.Howpublished);
        printtaaEiPakollinen("address", bg.Address);
        printtaaEiPakollinen("month", bg.Month);
        printtaaEiPakollinen("year", bg.Year);
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