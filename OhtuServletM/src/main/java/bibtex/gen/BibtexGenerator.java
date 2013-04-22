package bibtex.gen;

import bibtex.gens.ArticleGenerator;
import bibtex.gens.InproceedingsGenerator;
import bibtex.gens.BookGenerator;
import bibtex.gens.BookletGenerator;
import bibtex.gens.ConferenceGenerator;
import bibtex.gens.InbookGenerator;
import bibtex.gens.IncollectionGenerator;
import bibtex.gens.ManualGenerator;
import bibtex.gens.MastersthesisGenerator;
import bibtex.gens.MiscGenerator;
import bibtex.gens.PhdthesisGenerator;
import bibtex.gens.ProceedingsGenerator;
import bibtex.gens.TechreportGenerator;
import bibtex.gens.UnpublishedGenerator;
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
    public String Howpublished = "";
    public String Chapter = "";
    public String Type = "";
    public String School = "";
    public String Institution = "";
    PrintWriter sivuPrinter;
    PrintWriter filuPrinter;
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
        } else if (tyyppi.equals("howpublished")) {
            this.Howpublished = arvo;
        } else if (tyyppi.equals("chapter")) {
            this.Chapter = arvo;
        } else if (tyyppi.equals("type")) {
            this.Type = arvo;
        } else if (tyyppi.equals("school")) {
            this.School = arvo;
        } else if (tyyppi.equals("institution")) {
            this.Institution = arvo;
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

    private String checkArvo(String rivi) {
        String arvo = "";
        int indeksi = 0;
        // ensin katsotaan, mistä kohtaa @ löytyy
        for (int i = 0; i < rivi.length() - 1; i++) {
            if (rivi.charAt(i) == '@') {
                indeksi = i;
                break;
            }
        }

        for (int i = indeksi + 1; i < rivi.length(); i++) {
            arvo += rivi.charAt(i);
        }
        return arvo;
    }

    public void generoiBibtex() throws Exception {
        if (Tyyppi == null) {
            return;
        }
        if (Tyyppi.equals("article")) {
            ArticleGenerator BG = new ArticleGenerator(filuPrinter, sivuPrinter, this);
            BG.generoi();
        } else if (Tyyppi.equals("book")) {
            BookGenerator BG = new BookGenerator(filuPrinter, sivuPrinter, this);
            BG.generoi();
        } else if (Tyyppi.equals("booklet")) {
            BookletGenerator BG = new BookletGenerator(filuPrinter, sivuPrinter, this);
            BG.generoi();
        } else if (Tyyppi.equals("conference")) {
            ConferenceGenerator BG = new ConferenceGenerator(filuPrinter, sivuPrinter, this);
            BG.generoi();
        } else if (Tyyppi.equals("inbook")) {
            InbookGenerator BG = new InbookGenerator(filuPrinter, sivuPrinter, this);
            BG.generoi();
        } else if (Tyyppi.equals("incollection")) {
            IncollectionGenerator BG = new IncollectionGenerator(filuPrinter, sivuPrinter, this);
            BG.generoi();
        } else if (Tyyppi.equals("inproceedings")) {
            InproceedingsGenerator BG = new InproceedingsGenerator(filuPrinter, sivuPrinter, this);
            BG.generoi();
        } else if (Tyyppi.equals("manual")) {
            ManualGenerator BG = new ManualGenerator(filuPrinter, sivuPrinter, this);
            BG.generoi();
        } else if (Tyyppi.equals("mastersthesis")) {
            MastersthesisGenerator BG = new MastersthesisGenerator(filuPrinter, sivuPrinter, this);
            BG.generoi();
        } else if (Tyyppi.equals("misc")) {
            MiscGenerator BG = new MiscGenerator(filuPrinter, sivuPrinter, this);
            BG.generoi();
        } else if (Tyyppi.equals("phdthesis")) {
            PhdthesisGenerator BG = new PhdthesisGenerator(filuPrinter, sivuPrinter, this);
            BG.generoi();
        } else if (Tyyppi.equals("proceedings")) {
            ProceedingsGenerator BG = new ProceedingsGenerator(filuPrinter, sivuPrinter, this);
            BG.generoi();
        } else if (Tyyppi.equals("techreport")) {
            TechreportGenerator BG = new TechreportGenerator(filuPrinter, sivuPrinter, this);
            BG.generoi();
        } else if (Tyyppi.equals("unpublished")) {
            UnpublishedGenerator BG = new UnpublishedGenerator(filuPrinter, sivuPrinter, this);
            BG.generoi();
        }
    }

    private void luoFiluPrinter() {

        try {
//            this.filuPrinter = new PrintWriter(new FileWriter(file));
            FileWriter fw = new FileWriter(file, true);
            this.filuPrinter = new PrintWriter(fw);
        } catch (IOException e) {
            System.out.println("tekstitiedoston polkua ei löytynyt tms");
        }
    }

    private void luoTextFile() {
//        File dir = new File("/cs/fs/home/joeniemi/GithubProjects/pro-ada/BibtextGeneraattori");
//        File dir = new File("/Bibtexs");
//        dir.mkdirs(); // tekee polun (siis kansiot yms) jos niitä ei ole'
        if (testataanko) {
            this.file = new File("testitiedosto.bib");
        } else {
        this.file = new File("viitetiedosto.bib");
        }
        System.out.println(file.getAbsolutePath());
    }

    public void alustaTestejaVarten() {
        this.Tyyppi = "Martin09";
        this.Author = "Martin, Robert";
        this.Title = "Clean Code: A Handbook of Agile Software Craftsmanship";
        this.Year = "2008";
        this.Publisher = "Prentice Hall";
    }
    public void printFilu() {
        
    }
}
