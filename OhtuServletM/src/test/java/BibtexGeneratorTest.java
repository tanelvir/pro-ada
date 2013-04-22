
import bibtex.gen.BibtexGenerator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.*;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.*;
import static org.junit.Assert.*;

public class BibtexGeneratorTest extends TestCase {

    private Scanner testiLukija;
    // Monen bibtexin parametritaulut
    private ArrayList<String[]> parametriTaulut = new ArrayList<String[]>();
    private String[] articleParametrit = new String[25];
    private String[] bookParametrit = new String[25];
    private String[] inproceedingsParametrit = new String[25];

    public BibtexGeneratorTest(String testName) throws FileNotFoundException, IOException {
        super(testName);
        alustaArticlenParametrit();
        alustaMonenBibtexinTiedosto();
    }

    private void alustaArticlenParametrit() throws FileNotFoundException {
        articleParametrit[0] = "article";
        articleParametrit[1] = "ID@CBH91";
        articleParametrit[2] = "author@Allan Collins and John Seely Brown and Ann Holum";
        articleParametrit[3] = "title@Cognitive apprenticeship: making thinking visible";
        articleParametrit[4] = "journal@American Educator";
        articleParametrit[5] = "year@1991";
        articleParametrit[6] = "volume@6";
        articleParametrit[7] = "pages@38--46";

    }

    private void alustaMonenBibtexinTiedosto() throws FileNotFoundException {
        String[] taulu = new String[10];
        taulu[0] = "inproceedings";
        taulu[1] = "VPL11";
        taulu[2] = "author@Vihavainen, Arto and Paksula, Matti and Luukkainen, Matti";
        taulu[3] = "title@Extreme Apprenticeship Method in Teaching Programming for Beginners.";
        taulu[4] = "year@2011";
        taulu[5] = "booktitle@SIGCSE '11: Proceedings of the 42nd SIGCSE technical symposium on Computer science education";

        String taulu2[] = new String[10];
        taulu2[0] = "article";
        taulu2[1] = "ID@CBH91";
        taulu2[2] = "author@Allan Collins and John Seely Brown and Ann Holum";
        taulu2[3] = "title@Cognitive apprenticeship: making thinking visible";
        taulu2[4] = "journal@American Educator";
        taulu2[5] = "year@1991";
        taulu2[6] = "volume@6";
        taulu2[7] = "pages@38--46";

        String taulu3[] = new String[10];
        taulu3[0] = "book";
        taulu3[1] = "ID@BA04";
        taulu3[2] = "author@Beck, Kent and Andres, Cynthia";
        taulu3[3] = "title@Extreme Programming Explained: Embrace Change (2nd Edition)";
        taulu3[4] = "year@2004";
        taulu3[5] = "publisher@Addison-Wesley Professional";
        parametriTaulut.add(taulu);
        parametriTaulut.add(taulu2);
        parametriTaulut.add(taulu3);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void testBibtexGeneratorConstructor() throws FileNotFoundException, Exception {
//        String url = getClass().getClassLoader().getResource("articleBibtex").getFile();
        File filu = new File("tyhjaFilu");
        PrintWriter sivuPrinter;
        try {
            sivuPrinter = new PrintWriter(filu);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("ei löytynyt articleBibtex filua");
        }
        ArrayList<String[]> pt = new ArrayList<String[]>();
        BibtexGenerator BG = new BibtexGenerator(pt, sivuPrinter);
        assertNotNull("bibtexGenerator olio oli null", BG);
    }

    public void testArticleGenerator() throws FileNotFoundException, Exception {
        ArrayList<String[]> pt = new ArrayList<String[]>();
        pt.add(articleParametrit);
        BibtexGenerator BG = new BibtexGenerator(pt, null);

    }

//    private void tulosta() {
//        System.out.println("JEEEEEEEEEEEEEEEEEEEEEE");
//        // Menivätkö articlen parametrit oikein
//        for (int i = 0; i < articleParametrit.length; i++) {
//            if (articleParametrit[i] != null) {
//                System.out.println(articleParametrit[i]);
//            }
//        }
//    }
    
    
    
    
    
    
//        for (int i = 0; i < parametriTaulut.size(); i++) {
//            if (parametriTaulut[i] != null) {
//                System.out.println(parametriTaulut[i]);
//            }
//        }
}
//
//        Scanner lukija = new Scanner(new File("monenBibtexinTiedosto"));
//        int indeksi = 0;
//        String taulu[] = new String[25];
//        while (lukija.hasNextLine()) {
//            String rivi = lukija.nextLine();
//            if (rivi.equals("")) {
//                parametriTaulut.add(taulu);
//                taulu = new String[25];
//                indeksi = 0;
//            }
//            taulu[indeksi] = lukija.nextLine();
//            indeksi++;
//        }
//        lukija.close();
//        File filu = new File("articleBibtex");
//        Scanner lukija = new Scanner(filu);
//        int indeksi = 0;
//        while (lukija.hasNextLine()) {
//            articleParametrit[indeksi] = lukija.nextLine();;
//            indeksi++;
//        }
//        lukija.close();