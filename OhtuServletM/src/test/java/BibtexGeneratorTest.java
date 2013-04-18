
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
import static org.junit.Assert.*;

public class BibtexGeneratorTest extends TestCase {

    private Scanner testiLukija;
    // Monen bibtexin parametritaulut
    private ArrayList<String[]> parametriTaulut = new ArrayList<String[]>();
    private String[] articleParametrit = new String[25];
    private String[] bookParametrit = new String[25];
    private String[] inproceedingsParametrit = new String[25];

    public BibtexGeneratorTest(String testName) throws FileNotFoundException {
        super(testName);
        alustaArticlenParametrit();
        alustaMonenBibtexinTiedosto();
    }

    private void alustaArticlenParametrit() throws FileNotFoundException {
        File filu = new File("articleBibtex");
        Scanner lukija = new Scanner(filu);
        int indeksi = 0;
        while (lukija.hasNextLine()) {
            articleParametrit[indeksi] = lukija.nextLine();
            indeksi++;
        }
        lukija.close();
    }

    private void alustaMonenBibtexinTiedosto() throws FileNotFoundException {
        Scanner lukija = new Scanner(new File("monenBibtexinTiedosto"));
        int indeksi = 0;
        String taulu[] = new String[25];
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            if (rivi.equals("")) {
                parametriTaulut.add(taulu);
                taulu = new String[25];
                indeksi = 0;
            }
            taulu[indeksi] = lukija.nextLine();
            indeksi++;
        }
        lukija.close();
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
    public void testBibtexGeneratorConstructor() throws FileNotFoundException {
//        String url = getClass().getClassLoader().getResource("articleBibtex").getFile();
        File filu = new File("articleBibtex");
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

//    public void testArticleGenerator() throws FileNotFoundException {
//
////        File filu = new File("articleBibtex");
////        PrintWriter sivuPrinter;
////        try {
////            sivuPrinter = new PrintWriter(filu);
////        } catch (FileNotFoundException e) {
////            throw new FileNotFoundException("ei löytynyt articleBibtex filua");
////        }
//        ArrayList<String[]> parametriTaulut = new ArrayList<String[]>();
//        parametriTaulut.add(articleParametrit);
//        BibtexGenerator BG = new BibtexGenerator(parametriTaulut, null);
//
//    }
}