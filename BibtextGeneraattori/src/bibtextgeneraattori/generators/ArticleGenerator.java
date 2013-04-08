package bibtextgeneraattori.generators;

import bibtextgeneraattori.BibtexGenerator;
import bibtextgeneraattori.TextGenerator;
import java.io.PrintWriter;

public class ArticleGenerator implements TextGenerator {

    private PrintWriter out;
    private BibtexGenerator bg;

    public ArticleGenerator(PrintWriter out, BibtexGenerator bg) {
        this.out = out;
        this.bg = bg;
    }

    @Override
    public void generoi() {
        out.println("@article{" + bg.Tunnus + ",");
        printtaa("author", bg.Author);
        printtaa("title", bg.Title);
        printtaa("journal", bg.Journal);
        printtaa("year", bg.Year);
        printtaaEiPakollinen("volume", bg.Volume);
        printtaaEiPakollinen("number", bg.Number);
        printtaaEiPakollinen("pages", bg.Series);
        printtaaEiPakollinen("address", bg.Address);
        printtaaEiPakollinen("note", bg.Edition);
        printtaaEiPakollinen("key", bg.Month);
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