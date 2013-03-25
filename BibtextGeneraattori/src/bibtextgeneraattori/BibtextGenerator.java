/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bibtextgeneraattori;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Olettaa, että pakolliset kentät eivät ole tyhjiä
 * 
 */
public class BibtextGenerator {

    Scanner lukija = new Scanner(System.in);
    private String tyyppi; // kirja, artikkeli, inproceeding
                               
    public String Tunnus = "";
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
    PrintWriter out;
    File file;

    public BibtextGenerator() {
        luoTextFile();
        luoTextWriter();
    }

    public void generoiBibtext() {

        if (tyyppi.equals("kirja")) {
            GeneroiKirja gk = new GeneroiKirja(out, this);
            gk.generoi();
        }
        if (tyyppi.equals("artikkeli")) {
            GeneroiArtikkeli ga = new GeneroiArtikkeli(out, this);
            ga.generoi();
        }
        if (tyyppi.equals("inproceeding")) {
            GeneroiInproceeding gi = new GeneroiInproceeding(out, this);
            gi.generoi();
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
        File dir = new File("/cs/fs/home/joeniemi/GithubProjects/pro-ada/BibtextGeneraattori");
        dir.mkdirs(); // tekee polun (siis kansiot yms) jos niitä ei ole
        this.file = new File(dir, "viitetiedosto.txt");
    }

    public void alustaTestejaVarten() {
        this.tyyppi = "kirja";
        this.Tunnus = "Martin09";
        this.Author = "Martin, Robert";
        this.Title = "Clean Code: A Handbook of Agile Software Craftsmanship";
        this.Year = "2008";
        this.Publisher = "Prentice Hall";
        this.Volume = "19";
    }
}
