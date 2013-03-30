package bibtextgeneraattori.generators;

import bibtextgeneraattori.BibtextGenerator;
import bibtextgeneraattori.TextGenerator;
import java.io.PrintWriter;

public class MiscGenerator implements TextGenerator {

    private PrintWriter out;
    private BibtextGenerator bg;

    public MiscGenerator(PrintWriter out, BibtextGenerator bg) {
        this.out = out;
        this.bg = bg;
    }

    @Override
    public void generoi() {
        out.println("@misc{" + bg.Tunnus + ",");
        printtaaEiPakollinen("author", bg.Author);
        printtaaEiPakollinen("title", bg.Title);
        printtaaEiPakollinen("howpublished", bg.Howpublished);
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