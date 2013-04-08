package bibtexgeneraattori;

import bibtextgeneraattori.generators.ArticleGenerator;
import bibtextgeneraattori.generators.InproceedingsGenerator;
import bibtextgeneraattori.generators.BookGenerator;
import bibtextgeneraattori.generators.BookletGenerator;
import bibtextgeneraattori.generators.ConferenceGenerator;
import bibtextgeneraattori.generators.InbookGenerator;
import bibtextgeneraattori.generators.IncollectionGenerator;
import bibtextgeneraattori.generators.ManualGenerator;
import bibtextgeneraattori.generators.MastersthesisGenerator;
import bibtextgeneraattori.generators.MiscGenerator;
import bibtextgeneraattori.generators.PhdthesisGenerator;
import bibtextgeneraattori.generators.ProceedingsGenerator;
import bibtextgeneraattori.generators.TechreportGenerator;
import bibtextgeneraattori.generators.UnpublishedGenerator;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Olettaa, että pakolliset kentät eivät ole tyhjiä
 *
 */
public class BibtexGenerator {

    Scanner lukija = new Scanner(System.in);
    public String Tyyppi = ""; // kirja, artikkeli, inproceeding
    public String Tunnus = ""; // GvG00, A001 jne
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
    PrintWriter PR;
    File file;

    // Annetaan taulukko, jossa:
    // taulu[0] = tunnus@GvG00
    // taulu[1] = author@kirjailija
    public BibtexGenerator(String tyyppi, String[] parametrit, PrintWriter pr) {
        this.Tyyppi = tyyppi;
        this.PR = pr;
        luoTextFile();
        // Luodaan oma printwritteri jos ei saatu sitä parametrinä
        if (this.PR == null) {
            luoPrintWriter();
        }
        for (int i = 0; i < parametrit.length; i++) {
            // Jos taulussa on ylimääräisiä tyhjiä rivejä, lopetetaan
            if (parametrit[i] == null) {
                break;
            }
            String lisattavanTyyppi = checkTyyppi(parametrit[i]);
            String lisattavanArvo = checkArvo(parametrit[i]);
            lisaaParametri(lisattavanTyyppi, lisattavanArvo);
        }
    }

    private void lisaaParametri(String tyyppi, String arvo) {
        if (tyyppi.equals("tunnus")) {
            this.Tunnus = arvo;
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

    public void generoiBibtext() {
        if (Tyyppi.equals("article")) {
            ArticleGenerator BG = new ArticleGenerator(PR, this);
            BG.generoi();
        } else if (Tyyppi.equals("book")) {
            BookGenerator BG = new BookGenerator(PR, this);
            BG.generoi();
        } else if (Tyyppi.equals("booklet")) {
            BookletGenerator BG = new BookletGenerator(PR, this);
            BG.generoi();
        } else if (Tyyppi.equals("conference")) {
            ConferenceGenerator BG = new ConferenceGenerator(PR, this);
            BG.generoi();
        } else if (Tyyppi.equals("inbook")) {
            InbookGenerator BG = new InbookGenerator(PR, this);
            BG.generoi();
        } else if (Tyyppi.equals("incollection")) {
            IncollectionGenerator BG = new IncollectionGenerator(PR, this);
            BG.generoi();
        } else if (Tyyppi.equals("inproceedings")) {
            InproceedingsGenerator BG = new InproceedingsGenerator(PR, this);
            BG.generoi();
        } else if (Tyyppi.equals("manual")) {
            ManualGenerator BG = new ManualGenerator(PR, this);
            BG.generoi();
        } else if (Tyyppi.equals("mastersthesis")) {
            MastersthesisGenerator BG = new MastersthesisGenerator(PR, this);
            BG.generoi();
        } else if (Tyyppi.equals("misc")) {
            MiscGenerator BG = new MiscGenerator(PR, this);
            BG.generoi();
        } else if (Tyyppi.equals("phdthesis")) {
            PhdthesisGenerator BG = new PhdthesisGenerator(PR, this);
            BG.generoi();
        } else if (Tyyppi.equals("proceedings")) {
            ProceedingsGenerator BG = new ProceedingsGenerator(PR, this);
            BG.generoi();
        } else if (Tyyppi.equals("techreport")) {
            TechreportGenerator BG = new TechreportGenerator(PR, this);
            BG.generoi();
        } else if (Tyyppi.equals("unpublished")) {
            UnpublishedGenerator BG = new UnpublishedGenerator(PR, this);
            BG.generoi();
        }
    }

    private void luoPrintWriter() {

        try {
            this.PR = new PrintWriter(new FileWriter(file));
        } catch (IOException e) {
            System.out.println("tekstitiedoston polkua ei löytynyt tms");
        }
    }

    private void luoTextFile() {
//        File dir = new File("/cs/fs/home/joeniemi/GithubProjects/pro-ada/BibtextGeneraattori");
//        File dir = new File("/BibtextGenerator");
//        dir.mkdirs(); // tekee polun (siis kansiot yms) jos niitä ei ole
        this.file = new File("viitetiedosto.txt");
    }

    public void alustaTestejaVarten() {
        this.Tyyppi = "Martin09";
        this.Author = "Martin, Robert";
        this.Title = "Clean Code: A Handbook of Agile Software Craftsmanship";
        this.Year = "2008";
        this.Publisher = "Prentice Hall";
    }
}
//
//
//        if (tyyppi.equals("article")) {
//            ArticleGenerator BG = new ArticleGenerator(out, this);
//            BG.generoi();
//        } else if (tyyppi.equals("book")) {
//            BookGenerator BG = new BookGenerator(out, this);
//            BG.generoi();
//        } else if (tyyppi.equals("booklet")) {
//            BookletGenerator BG = new BookletGenerator(out, this);
//            BG.generoi();
//        } else if (tyyppi.equals("conference")) {
//            ConferenceGenerator BG = new ConferenceGenerator(out, this);
//            BG.generoi();
//        } else if (tyyppi.equals("inbook")) {
//            InbookGenerator BG = new InbookGenerator(out, this);
//            BG.generoi();
//        } else if (tyyppi.equals("incollection")) {
//            IncollectionGenerator BG = new IncollectionGenerator(out, this);
//            BG.generoi();
//        } else if (tyyppi.equals("inproceedings")) {
//            InproceedingsGenerator BG = new InproceedingsGenerator(out, this);
//            BG.generoi();
//        } else if (tyyppi.equals("manual")) {
//            ManualGenerator BG = new ManualGenerator(out, this);
//            BG.generoi();
//        } else if (tyyppi.equals("mastersthesis")) {
//            MastersthesisGenerator BG = new MastersthesisGenerator(out, this);
//            BG.generoi();
//        } else if (tyyppi.equals("misc")) {
//            MiscGenerator BG = new MiscGenerator(out, this);
//            BG.generoi();
//        } else if (tyyppi.equals("phdthesis")) {
//            PhdthesisGenerator BG = new PhdthesisGenerator(out, this);
//            BG.generoi();
//        } else if (tyyppi.equals("proceedings")) {
//            ProceedingsGenerator BG = new ProceedingsGenerator(out, this);
//            BG.generoi();
//        } else if (tyyppi.equals("techreport")) {
//            TechreportGenerator BG = new TechreportGenerator(out, this);
//            BG.generoi();
//        } else if (tyyppi.equals("unpublished")) {
//            UnpublishedGenerator BG = new UnpublishedGenerator(out, this);
//            BG.generoi();
//        }
//
//String tyyppi, String tunnus, String author, String title,
//            String publisher, String address, String journal, String pages, String booktitle,
//            String note, String year, String volume, String number, String month, String key,
//            String series, String edition, String editor, String organization, String howpublished,
//            String chapter, String type, String school, String institution