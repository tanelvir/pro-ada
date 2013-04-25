package bibtex.gen;

import bibtex.gens.ArticleGenerator;
import bibtex.gens.InproceedingsGenerator;
import bibtex.gens.BookGenerator;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Olettaa, että pakolliset kentät eivät ole tyhjiä
 *
 */
public class BibtexGenerator {

    Scanner lukija = new Scanner(System.in);
    public String Tyyppi = ""; // kirja, artikkeli, inproceeding
    public String ID = ""; // GvG00, A001 jne
    public String Author = "";
    public String Title = "";
    public String Publisher = "";
    public String Address = "";
    public String Journal = "";
    public String Pages = "";
    public String Booktitle = "";
    public String Note = "";
    public String Year = "";
    public String Volume = "";
    public String Number = "";
    public String Month = "";
    public String Key = "";
    public String Series = "";
    public String Edition = "";
    public String Editor = "";
    public String Organization = "";
    public PrintWriter sivuPrinter;
    public PrintWriter filuPrinter;
    public File file;
    public boolean suljetaanko = false;
    public boolean testataanko;

    public BibtexGenerator(ArrayList<String[]> parametriTaulut, PrintWriter sivuPrinter, boolean testataanko) throws Exception {
        this.testataanko = testataanko;
        this.sivuPrinter = sivuPrinter;

        luoTextFile();
        luoFiluPrinter();
        if (sivuPrinter != null) {
            suljetaanko = true;
        }
        // Luodaan oma printwritteri jos ei saatu sitä parametrinä
        if (this.sivuPrinter == null) {
            System.out.println("sivu printteriä ei annettu");
//            luoSivuPrinter();
        }
        BibtexPrinter BP = new BibtexPrinter(sivuPrinter, filuPrinter, this);
        muodostaBibtexit(parametriTaulut);
    }

    private void muodostaBibtexit(ArrayList<String[]> parametriTaulut) throws Exception {
        for (int i = 0; i < parametriTaulut.size(); i++) {
            // Viimeisen bibtex printin jälkeen printterit suljetaan
            if (i == parametriTaulut.size() - 1) {
                suljetaanko = true;
            }
            alustaYhdenBibtexinParametrit(parametriTaulut.get(i));
            generoiBibtex();
        }
    }

    private void alustaYhdenBibtexinParametrit(String[] parametrit) throws Exception {
        // Tyhjennetään ensin vanhat kentät
        alustaKentatTyhjijsi();
        // tyyppi = id, author, title, article jne
        this.Tyyppi = parametrit[0];
        for (int i = 1; i < parametrit.length; i++) {
            // Jos taulussa on ylimääräisiä tyhjiä rivejä, lopetetaan
            if (parametrit[i] == null) {
                break;
            }
            String lisattavanTyyppi = checkTyyppi(parametrit[i]);
            String lisattavanArvo = checkArvo(parametrit[i]);
            lisaaParametri(lisattavanTyyppi, lisattavanArvo);
        }
    }

    private void lisaaParametri(String tyyppi, String arvo) throws Exception {
        tyyppi = tyyppi.toLowerCase();
        if (tyyppi.equals("id")) {
            this.ID = arvo;
        } else if (tyyppi.equals("author")) {
            this.Author = arvo;
        } else if (tyyppi.equals("title")) {
            this.Title = arvo;
        } else if (tyyppi.equals("publisher")) {
            this.Publisher = arvo;
        } else if (tyyppi.equals("address")) {
            this.Address = arvo;
        } else if (tyyppi.equals("journal")) {
            this.Journal = arvo;
        } else if (tyyppi.equals("pages")) {
            this.Pages = arvo;
        } else if (tyyppi.equals("booktitle")) {
            this.Booktitle = arvo;
        } else if (tyyppi.equals("note")) {
            this.Note = arvo;
        } else if (tyyppi.equals("year")) {
            this.Year = arvo;
        } else if (tyyppi.equals("volume")) {
            this.Volume = arvo;
        } else if (tyyppi.equals("number")) {
            this.Number = arvo;
        } else if (tyyppi.equals("month")) {
            this.Month = arvo;
        } else if (tyyppi.equals("key")) {
            this.Key = arvo;
        } else if (tyyppi.equals("series")) {
            this.Series = arvo;
        } else if (tyyppi.equals("edition")) {
            this.Edition = arvo;
        } else if (tyyppi.equals("editor")) {
            this.Editor = arvo;
        } else if (tyyppi.equals("organization")) {
            this.Organization = arvo;
        }
    }

    private String checkTyyppi(String rivi) {
        String tyyppi = "";
        for (int i = 0; i < rivi.length(); i++) {
            if (rivi.charAt(i) == '@') {
                break;
            }
            tyyppi += rivi.charAt(i);
        }
        return tyyppi;
    }

    // Hakee rivin @ jälkeisen arvon, esim rivistä "journal@American Educator"
    // metodi palauttaa "American Educator"
    private String checkArvo(String rivi) {
        int indeksi = 0;
        // ensin katsotaan, mistä kohtaa @ löytyy
        for (int i = 0; i < rivi.length() - 1; i++) {
            if (rivi.charAt(i) == '@') {
                indeksi = i;
                break;
            }
        }
        return rivi.substring(indeksi+1);
    }

    public void generoiBibtex() throws Exception {
        if (Tyyppi.equals("article")) {
            ArticleGenerator BG = new ArticleGenerator(filuPrinter, sivuPrinter, this);
            BG.generoi();
        } else if (Tyyppi.equals("book")) {
            BookGenerator BG = new BookGenerator(filuPrinter, sivuPrinter, this);
            BG.generoi();
        } else {
            InproceedingsGenerator BG = new InproceedingsGenerator(filuPrinter, sivuPrinter, this);
            BG.generoi();
        }
    }

    private void luoFiluPrinter() {

        try {
            FileWriter fw = new FileWriter(file, true);
            this.filuPrinter = new PrintWriter(fw);
        } catch (IOException e) {
            System.out.println("tekstitiedoston polkua ei löytynyt tms");
        }
    }

    private void luoTextFile() {
        if (testataanko) {
            this.file = new File("testitiedosto.bib");
        } else {
            this.file = new File("viitetiedosto.bib");
        }
        System.out.println(file.getAbsolutePath());
    }

    private void alustaKentatTyhjijsi() {
        Tyyppi = "";
        ID = "";
        Author = "";
        Title = "";
        Publisher = "";
        Address = "";
        Journal = "";
        Pages = "";
        Booktitle = "";
        Note = "";
        Year = "";
        Volume = "";
        Number = "";
        Month = "";
        Key = "";
        Series = "";
        Edition = "";
        Editor = "";
        Organization = "";
    }
}
