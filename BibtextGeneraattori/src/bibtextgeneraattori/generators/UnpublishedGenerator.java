package bibtextgeneraattori.generators;

import bibtextgeneraattori.BibtexGenerator;
import bibtextgeneraattori.TextGenerator;
import java.io.PrintWriter;

public class UnpublishedGenerator implements TextGenerator {

    private PrintWriter out;
    private BibtexGenerator bg;

    public UnpublishedGenerator(PrintWriter out, BibtexGenerator bg) {
        this.out = out;
        this.bg = bg;
    }

    @Override
    public void generoi() {
        out.println("unpublished@{" + bg.Tyyppi + ",");
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