
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
        BibtexGenerator bg = new BibtexGenerator();
        bg.Tyyppi = "article";
        bg.Tunnus = "W04";
        bg.Author = "Whittington, Keith J.";
        bg.Title = "Infusing active learning into introductory programming courses";
        bg.Journal = "J. Comput. Small Coll.";
        bg.Volume = "19";
        bg.Number = "5";
        bg.Year = "2004";
        bg.Pages = "249--259";
        bg.Publisher = "Consortium for Computing Sciences in Colleges";
        bg.Address = "USA";
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
        r = lukija.nextLine();
        assertEquals("pages = {249--259},", r);
        r = lukija.nextLine();
        assertEquals("publisher = {Consortium for Computing Sciences in Colleges},", r);
        r = lukija.nextLine();
        assertEquals("address = {USA},", r);
        r = lukija.nextLine();
        assertEquals("}", r);
        lukija.close();
    }
}
