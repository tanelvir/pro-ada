package bibtextgeneraattori.generators;

import bibtextgeneraattori.BibtextGenerator;
import bibtextgeneraattori.TextGenerator;
import java.io.PrintWriter;

public class ArticleGenerator implements TextGenerator {

    private PrintWriter out;
    private BibtextGenerator bg;

    public ArticleGenerator(PrintWriter out, BibtextGenerator bg) {
        this.out = out;
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
        printtaaEiPakollinen("month", bg.Address);
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