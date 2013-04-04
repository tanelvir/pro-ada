package bibtextgeneraattori.generators;

import bibtextgeneraattori.BibtexGenerator;
import bibtextgeneraattori.TextGenerator;
import java.io.PrintWriter;

public class ManualGenerator implements TextGenerator {

    private PrintWriter out;
    private BibtexGenerator bg;

    public ManualGenerator(PrintWriter out, BibtexGenerator bg) {
        this.out = out;
        this.bg = bg;
    }

    @Override
    public void generoi() {
        out.println("@manual{" + bg.Tyyppi + ",");
        printtaa("title", bg.Title);
        printtaaEiPakollinen("author", bg.Author);
        printtaaEiPakollinen("organization", bg.Organization);
        printtaaEiPakollinen("address", bg.Address);
        printtaaEiPakollinen("edition", bg.Edition);
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