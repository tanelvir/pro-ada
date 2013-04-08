package bibtextgeneraattori.generators;

import bibtexgeneraattori.BibtexGenerator;
import bibtexgeneraattori.TextGenerator;
import java.io.PrintWriter;

public class IncollectionGenerator implements TextGenerator {

    private PrintWriter out;
    private BibtexGenerator bg;

    public IncollectionGenerator(PrintWriter out, BibtexGenerator bg) {
        this.out = out;
        this.bg = bg;
    }

    @Override
    public void generoi() {
        out.println("@incollection{" + bg.Tyyppi + ",");
        printtaa("author", bg.Author);
        printtaa("title", bg.Title);
        printtaa("booktitle", bg.Booktitle);
        printtaa("publisher", bg.Publisher);
        printtaa("year", bg.Year);
        printtaaEiPakollinen("editor", bg.Editor);
        printtaaEiPakollinen("volume", bg.Volume);
        printtaaEiPakollinen("number", bg.Number);
        printtaaEiPakollinen("series", bg.Series);
        printtaaEiPakollinen("type", bg.Type);
        printtaaEiPakollinen("chapter", bg.Chapter);
        printtaaEiPakollinen("pages", bg.Pages);
        printtaaEiPakollinen("address", bg.Address);
        printtaaEiPakollinen("edition", bg.Edition);
        printtaaEiPakollinen("month", bg.Month);
        printtaaEiPakollinen("note", bg.Note);
        printtaaEiPakollinen("key", bg.Key);
        out.println("}");
        if (bg.suljetaanko) {
            out.close();
        }
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