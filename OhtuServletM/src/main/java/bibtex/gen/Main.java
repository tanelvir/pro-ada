package bibtex.gen;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
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
        
        ArrayList<String[]> pt = new ArrayList<String[]>();
        pt.add(taulu);
        pt.add(taulu2);
        pt.add(taulu3);
        
        BibtexGenerator bg = new BibtexGenerator(pt, null, true);
        
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