package bibtex.gen;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        
        String[] taulu = new String[10];
        taulu[0] = "inproceedings";
        taulu[1] = "ID@VPL11";
        taulu[2] = "author@Vihavainen, Arto and Paksula, Matti and Luukkainen, Matti";
        taulu[3] = "title@Extreme Apprenticeship Method in Teaching Programming for Beginners.";
        taulu[4] = "year@2011";
        taulu[5] = "booktitle@SIGCSE '11: Proceedings of the 42nd SIGCSE technical symposium on Computer science education";
        taulu[6] = "organization@Computer Science Department";

        String taulu2[] = new String[10];
        taulu2[0] = "article";
        taulu2[1] = "ID@CBH91";
        taulu2[2] = "author@Allan Collins and John Seely Brown and Ann Holum";
        taulu2[3] = "title@Cognitive apprenticeship: making thinking visible";
        taulu2[4] = "journal@American Educator";
        taulu2[5] = "year@1991";
        taulu2[6] = "volume@6";
        taulu2[7] = "pages@38--46";

        String taulu3[] = new String[15];
        taulu3[0] = "book";
        taulu3[1] = "ID@BA04";
        taulu3[2] = "author@Beck, Kent and Andres, Cynthia";
        taulu3[3] = "title@Extreme Programming Explained: Embrace Change (2nd Edition)";
        taulu3[4] = "year@2004";
        taulu3[5] = "publisher@Addison-Wesley Professional";
        taulu3[6] = "series@Extreme Programming";
        taulu3[7] = "address@Backstreet 123";
        taulu3[8] = "edition@Edition 2.27";
        taulu3[9] = "month@January";
        taulu3[10] = "note@Best Book Ever";
        taulu3[11] = "key@SuperKey123";

        String taulu4[] = new String[15];
        taulu4[0] = "book";
        taulu4[1] = "ID@124";
        taulu4[2] = "author@Kalle Päätalo";
        taulu4[3] = "editor@Kallekallekalle";
        taulu4[4] = "title@Höylin Miehen Syksy";
        taulu4[5] = "publisher@WSOY";
        taulu4[6] = "year@1970";
        taulu4[7] = "Edition@Ämpäri Öljy äiti :D";
        taulu4[8] = "month@February";


        ArrayList<String[]> pt = new ArrayList<String[]>();
        pt.add(taulu);
        pt.add(taulu2);
        pt.add(taulu3);
        pt.add(taulu4);

        BibtexGenerator bg = new BibtexGenerator(pt, null, false);

    }
}