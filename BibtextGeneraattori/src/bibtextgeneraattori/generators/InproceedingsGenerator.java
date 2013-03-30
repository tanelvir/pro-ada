package bibtextgeneraattori.generators;

import bibtextgeneraattori.BibtextGenerator;
import bibtextgeneraattori.TextGenerator;
import java.io.PrintWriter;

public class InproceedingsGenerator implements TextGenerator {

    private PrintWriter out;
    private BibtextGenerator bg;

    public InproceedingsGenerator(PrintWriter out, BibtextGenerator bg) {
        this.out = out;
        this.bg = bg;
    }

    @Override
    public void generoi() {
        out.println("inproceedings@{" + bg.Tunnus + ",");
        printtaa("author", bg.Author);
        printtaa("title", bg.Title);
        printtaa("booktitle", bg.Year);
        printtaa("year", bg.Year);
        printtaaEiPakollinen("editor", bg.Editor);
        printtaaEiPakollinen("volume", bg.Volume);
        printtaaEiPakollinen("number", bg.Number);
        printtaaEiPakollinen("series", bg.Series);
        printtaaEiPakollinen("pages", bg.Pages);
        printtaaEiPakollinen("address", bg.Address);
        printtaaEiPakollinen("month", bg.Month);
        printtaaEiPakollinen("organization", bg.Organization);
        printtaaEiPakollinen("publisher", bg.Publisher);
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