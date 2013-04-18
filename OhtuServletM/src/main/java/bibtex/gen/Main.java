package bibtex.gen;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String[] taulu = new String[10];
        taulu[0] = "inproceedigns";
        taulu[1] = "tunnus@W04";
        taulu[2] = "author@Whittington, Keith J.";
        taulu[3] = "title@Infusing active learning into introductory programming courses";
        taulu[4] = "journal@J. Comput. Small Coll.";
        taulu[5] = "year@2004";
        taulu[6] = "volume@19";
        taulu[7] = "number@5";
        taulu[8] = "address@USA";
        ArrayList<String[]> pt = new ArrayList<String []>();
        pt.add(taulu);
        BibtexGenerator bg = new BibtexGenerator(pt, null);
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