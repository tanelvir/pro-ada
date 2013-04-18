package bibtex.gen;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String[] taulu = new String[10];
        taulu[0] = "inproceedings";
        taulu[1] = "tunnus@W04";
        taulu[2] = "author@Whittington, Keith J.";
        taulu[3] = "title@Infusing active learning into introductory programming courses";
        taulu[4] = "journal@J. Comput. Small Coll.";
        taulu[5] = "year@2004";
        taulu[6] = "volume@19";
        taulu[7] = "number@5";
        taulu[8] = "address@USA";

        String taulu2[] = new String[10];
        taulu2[0] = "article";
        taulu2[1] = "tunnus@CBH91";
        taulu2[2] = "author@Allan Collins and John Seely Brown and Ann Holum";
        taulu2[3] = "title@Cognitive apprenticeship: making thinking visible";
        taulu2[4] = "journal@J. safdassadl.";
        taulu2[5] = "year@2001";
        taulu2[6] = "volume@15";
        taulu2[7] = "number@5";
        taulu2[8] = "address@LOL";

        ArrayList<String[]> pt = new ArrayList<String[]>();
        pt.add(taulu);
        pt.add(taulu2);
        
        BibtexGenerator bg = new BibtexGenerator(pt, null);
    }
}



//@ARTICLE{CBH91,
//    author = {Allan Collins and John Seely Brown and Ann Holum},
//    title = {Cognitive apprenticeship: making thinking visible},
//    journal = {American Educator},
//    year = {1991},
//    volume = {6},
//    pages = {38--46}
    
    
    
    
    
//@article{W04,
//author = {Whittington, Keith J.},
//title = {Infusing active learning into introductory programming courses},
//journal = {J. Comput. Small Coll.},
//year = {2004},
//volume = {19},
//number = {5},
//address = {USA},
//}