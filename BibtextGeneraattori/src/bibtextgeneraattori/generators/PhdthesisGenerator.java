package bibtextgeneraattori.generators;

import bibtextgeneraattori.BibtexGenerator;
import bibtextgeneraattori.TextGenerator;
import java.io.PrintWriter;

public class PhdthesisGenerator implements TextGenerator {

    private PrintWriter out;
    private BibtexGenerator bg;

    public PhdthesisGenerator(PrintWriter out, BibtexGenerator bg) {
        this.out = out;
        this.bg = bg;
    }

    @Override
    public void generoi() {
        out.println("phdthesis@{" + bg.Tyyppi + ",");
        printtaa("author", bg.Author);
        printtaa("title", bg.Title);
        printtaa("school", bg.School);
        printtaa("year", bg.Year);
        printtaaEiPakollinen("type", bg.Type);
        printtaaEiPakollinen("address", bg.Address);
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