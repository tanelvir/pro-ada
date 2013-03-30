package bibtextgeneraattori.generators;

import bibtextgeneraattori.BibtextGenerator;
import bibtextgeneraattori.TextGenerator;
import java.io.PrintWriter;

public class UnpublishedGenerator implements TextGenerator {

    private PrintWriter out;
    private BibtextGenerator bg;

    public UnpublishedGenerator(PrintWriter out, BibtextGenerator bg) {
        this.out = out;
        this.bg = bg;
    }

    @Override
    public void generoi() {
        out.println("unpublished@{" + bg.Tunnus + ",");
        printtaa("author", bg.Author);
        printtaa("title", bg.Title);
        printtaa("note", bg.Note);
        printtaaEiPakollinen("month", bg.Month);
        printtaaEiPakollinen("year", bg.Year);
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