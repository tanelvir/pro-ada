/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bibtextgeneraattori;

import java.io.PrintWriter;

/**
 *
 * @author joeniemi
 */
public class GeneroiArtikkeli implements TextGenerator {

    private PrintWriter out;
    private BibtextGenerator bg;

    public GeneroiArtikkeli(PrintWriter out, BibtextGenerator bg) {
        this.out = out;
    }

    @Override
    public void generoi() {
        out.println("@book{" + bg.Tunnus + ",");
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
            printtaa("nimi", mita);
        }
    }

    private void printtaa(String nimi, String mita) {
        out.println(nimi + " = {" + mita + "},");
    }
}