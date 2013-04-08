package bibtextgeneraattori;

public class Main {

    public static void main(String[] args) {
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
        BibtexGenerator b = new BibtexGenerator(tyyppi, taulu);
//        b.alustaTestejaVarten();
        b.generoiBibtext();
    }
}
//@article{W04,
//author = {Whittington, Keith J.},
//title = {Infusing active learning into introductory programming courses},
//journal = {J. Comput. Small Coll.},
//year = {2004},
//volume = {19},
//number = {5},
//address = {USA},
//}