
import bibtextgeneraattori.BibtexGenerator;
import java.io.File;
import java.util.Scanner;
import junit.framework.TestCase;

public class BibtexGeneratorTest extends TestCase {

    private Scanner lukija;

    public BibtexGeneratorTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        String tyyppi = "article";
        String[] taulu = new String[10];
        taulu[0] = "tunnus@W04";
        taulu[1] = "author@Whittington, Keith J.";
        taulu[2] = "title@Infusing active learning into introductory programming courses";
        taulu[3] = "journal@J. Comput. Small Coll.";
        taulu[4] = "year@2004";
        taulu[5] = "volume@19";
        taulu[6] = "number@5";
        taulu[7] = "address@USA";
        BibtexGenerator bg = new BibtexGenerator(tyyppi, taulu);
        bg.generoiBibtext();
        File filu = new File("viitetiedosto.txt");
        this.lukija = new Scanner(filu);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testArticleGenerator() {
        String r = lukija.nextLine();
        assertEquals("@article{W04,", r);
        r = lukija.nextLine();
        assertEquals("author = {Whittington, Keith J.},", r);
        r = lukija.nextLine();
        assertEquals("title = {Infusing active learning into introductory programming courses},", r);
        r = lukija.nextLine();
        assertEquals("journal = {J. Comput. Small Coll.},", r);
        r = lukija.nextLine();
        assertEquals("year = {2004},", r);
        r = lukija.nextLine();
        assertEquals("volume = {19},", r);
        r = lukija.nextLine();
        assertEquals("number = {5},", r);
        // "extroja:"
//        r = lukija.nextLine();
//        assertEquals("pages = {249--259},", r);
//        r = lukija.nextLine();
//        assertEquals("publisher = {Consortium for Computing Sciences in Colleges},", r);
        r = lukija.nextLine();
        assertEquals("address = {USA},", r);
        r = lukija.nextLine();
        assertEquals("}", r);
        lukija.close();
    }
}
