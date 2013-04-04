package bibtextgeneraattori;

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
    PrintWriter out;
    File file;

    public BibtexGenerator() {
        luoTextFile();
        luoTextWriter();
    }

    public void generoiBibtext() {
        switch (Tyyppi) {
            case "article": {
                new ArticleGenerator(out, this).generoi();
                break;
            }
            case "book": {
                new BookGenerator(out, this).generoi();
                break;
            }
            case "booklet": {
                new BookletGenerator(out, this).generoi();
                break;
            }
            case "conference": {
                new ConferenceGenerator(out, this).generoi();
                break;
            }
            case "inbook": {
                new InbookGenerator(out, this).generoi();
                break;
            }
            case "incollection": {
                new IncollectionGenerator(out, this).generoi();
                break;
            }
            case "inproceedings": {
                new InproceedingsGenerator(out, this).generoi();
                break;
            }
            case "manual": {
                new ManualGenerator(out, this).generoi();
                break;
            }
            case "mastersthesis": {
                new MastersthesisGenerator(out, this).generoi();
                break;
            }
            case "misc": {
                new MiscGenerator(out, this).generoi();
                break;
            }
            case "phdthesis": {
                new PhdthesisGenerator(out, this).generoi();
                break;
            }
            case "proceedings": {
                new ProceedingsGenerator(out, this).generoi();
                break;
            }
            case "techreport": {
                new TechreportGenerator(out, this).generoi();
                break;
            }
            case "unpublished": {
                new UnpublishedGenerator(out, this).generoi();
                break;
            }
        }
    }

    private void luoTextWriter() {

        try {
            this.out = new PrintWriter(new FileWriter(file));
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