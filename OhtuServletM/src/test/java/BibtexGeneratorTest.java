
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
    private Scanner lukija;

    public BibtexGeneratorTest(String testName) throws FileNotFoundException, IOException {
        super(testName);
        alustaMonenBibtexinTiedosto();
    }

    private void alustaMonenBibtexinTiedosto() throws FileNotFoundException {
        String[] taulu = new String[10];
        taulu[0] = "inproceedings";
        taulu[1] = "ID@VPL11";
        taulu[2] = "author@Vihavainen, Arto and Paksula, Matti and Luukkainen, Matti";
        taulu[3] = "title@Extreme Apprenticeship Method in Teaching Programming for Beginners.";
        taulu[4] = "booktitle@SIGCSE '11: Proceedings of the 42nd SIGCSE technical symposium on Computer science education";
        taulu[5] = "year@2011";
        this.inproceedingsParametrit = taulu;

        String taulu2[] = new String[10];
        taulu2[0] = "article";
        taulu2[1] = "ID@CBH91";
        taulu2[2] = "author@Allan Collins and John Seely Brown and Ann Holum";
        taulu2[3] = "title@Cognitive apprenticeship: making thinking visible";
        taulu2[4] = "journal@American Educator";
        taulu2[5] = "year@1991";
        taulu2[6] = "volume@6";
        taulu2[7] = "pages@38--46";
        this.articleParametrit = taulu2;

        String taulu3[] = new String[10];
        taulu3[0] = "book";
        taulu3[1] = "ID@BA04";
        taulu3[2] = "author@Beck, Kent and Andres, Cynthia";
        taulu3[3] = "title@Extreme Programming Explained: Embrace Change (2nd Edition)";
        taulu3[4] = "year@2004";
        taulu3[5] = "publisher@Addison-Wesley Professional";
        this.bookParametrit = taulu3;

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

    private void alustaTestejaVarten(ArrayList<String[]> pt) throws Exception {
        File poistetaanEnsin = new File("testitiedosto.bib");
        poistetaanEnsin.createNewFile();
        poistetaanEnsin.delete();
        BibtexGenerator BG = new BibtexGenerator(pt, null, true);

        File testFilu = new File("testitiedosto.bib");
        lukija = new Scanner(testFilu);
    }

    @Test
    public void testBibtexGeneratorConstructor() throws FileNotFoundException, Exception {
        File filu = new File("tyhjaFilu");
        PrintWriter sivuPrinter;
        try {
            sivuPrinter = new PrintWriter(filu);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("ei löytynyt articleBibtex filua");
        }
        ArrayList<String[]> pt = new ArrayList<String[]>();
        BibtexGenerator BG = new BibtexGenerator(pt, sivuPrinter, true);
        assertNotNull("bibtexGenerator olio oli null", BG);
    }

    @Test
    public void testArticleGenerator() throws FileNotFoundException, Exception {
        ArrayList<String[]> pt = new ArrayList<String[]>();
        pt.add(articleParametrit);
        alustaTestejaVarten(pt);
        String rivi = lukija.nextLine();
        assertEquals("@article{CBH91,", rivi);
        rivi = lukija.nextLine();
        assertEquals("author = {Allan Collins and John Seely Brown and Ann Holum},", rivi);
        rivi = lukija.nextLine();
        assertEquals("title = {Cognitive apprenticeship: making thinking visible},", rivi);
        rivi = lukija.nextLine();
        assertEquals("journal = {American Educator},", rivi);
        rivi = lukija.nextLine();
        assertEquals("year = {1991},", rivi);
        rivi = lukija.nextLine();
        assertEquals("volume = {6},", rivi);
        rivi = lukija.nextLine();
        assertEquals("pages = {38--46},", rivi);
        rivi = lukija.nextLine();
        assertEquals("}", rivi);
    }

    @Test
    public void testBookGenerator() throws FileNotFoundException, Exception {
        ArrayList<String[]> pt = new ArrayList<String[]>();
        pt.add(bookParametrit);
        alustaTestejaVarten(pt);
        String rivi = lukija.nextLine();
        assertEquals("@book{BA04,", rivi);
        rivi = lukija.nextLine();
        assertEquals("author = {Beck, Kent and Andres, Cynthia},", rivi);
        rivi = lukija.nextLine();
        assertEquals("title = {Extreme Programming Explained: Embrace Change (2nd Edition)},", rivi);
        rivi = lukija.nextLine();
        assertEquals("year = {2004},", rivi);
        rivi = lukija.nextLine();
        assertEquals("publisher = {Addison-Wesley Professional},", rivi);
        rivi = lukija.nextLine();
        assertEquals("}", rivi);
    }

    @Test
    public void testInproceedingsGenerator() throws FileNotFoundException, Exception {
        ArrayList<String[]> pt = new ArrayList<String[]>();
        pt.add(inproceedingsParametrit);
        alustaTestejaVarten(pt);
        String rivi = lukija.nextLine();
        assertEquals("@inproceedings{VPL11,", rivi);
        rivi = lukija.nextLine();
        assertEquals("author = {Vihavainen, Arto and Paksula, Matti and Luukkainen, Matti},", rivi);
        rivi = lukija.nextLine();
        assertEquals("title = {Extreme Apprenticeship Method in Teaching Programming for Beginners.},", rivi);
        rivi = lukija.nextLine();
        assertEquals("booktitle = {SIGCSE '11: Proceedings of the 42nd SIGCSE technical symposium on Computer science education},", rivi);
        rivi = lukija.nextLine();
        assertEquals("year = {2011},", rivi);
        rivi = lukija.nextLine();
        assertEquals("}", rivi);
    }
}
