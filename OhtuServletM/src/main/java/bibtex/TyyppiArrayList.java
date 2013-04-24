/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bibtex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 */
public class TyyppiArrayList extends ArrayList<String[]> {

    private HashMap<String, String[]> tunnukset;//ID:t
    
    
    public TyyppiArrayList() {
        tunnukset = new HashMap<String, String[]>();
    }
    
    
    
    /**
     * Etsii ID:n parametrien joukosta
     * @param parametrit parametrit. Key ennen @ osaa ja value sen jälkeen.
     * @return Löydetty ID value.
     */
    private static String etsiID(String[] parametrit) {
        for (String parametri : parametrit) {
            if (parametri.toLowerCase().startsWith("id@")) {
                return parametri.substring(3); 
            }
        }
        return null;
    }
    
    
    /**
     * Generoi vapaan ID:n jota tämä ArrayList ei vielä sisällä.
     * @return Pienin vapaa ID.
     */
    public String generoiVapaaID() {
        int testattavaID = 0;
        boolean varattu;
        do {
            testattavaID++;
            varattu = false;
            for (String tunnus : tunnukset.keySet()) {
                if (tunnus.equals(""+testattavaID)) {
                    varattu = true;
                    break;
                } 
            }
        } while(varattu);
        return ""+testattavaID;
    }
    
    
    @Override
    public String[] remove(int index) {
        tunnukset.remove(etsiID(get(index)));
        return super.remove(index);
    }
    
    /**
     * Poistaa annetun alkion ArrayListasta ja vapauttaa ID:n samalla.
     * @param alkio joka poistetaan
     * @return onnistuuko poisto
     */
    @Override
    public boolean remove(Object o) {
        String ID = this.etsiID((String[]) o);
        System.out.println("poistettavan ID: "+ID);
        for (Map.Entry<String, String[]> tunnus : tunnukset.entrySet()) {
            if (tunnus.getKey().equals(ID)) {
                System.out.println("ID löydetty... poistetaan");
                tunnukset.remove(tunnus.getKey());
                return super.remove(tunnus.getValue());
            }
        }
        return false;
    }
    
    /**
     * Lisää parametreihin käyttämättömän ID:n ja lisää parametrit tähän ArrayListaan.
     * Ei tarkista sisältääkö parametrit jo ID:n
     * @param lisattavanParametrit parametrit joihin ID lisätään.
     * @return Onnistuuko lisäys
     */
    public boolean lisaaIlmanTunnusta(String[] lisattavanParametrit) {
        String lisattavaID = generoiVapaaID();
        lisattavanParametrit = Arrays.copyOfRange(lisattavanParametrit, 0, lisattavanParametrit.length+1);
        lisattavanParametrit[lisattavanParametrit.length-1] = "id@"+lisattavaID;
        tunnukset.put(lisattavaID, lisattavanParametrit);
        return super.add(lisattavanParametrit);
    }
    
    
    /**
     * Lisää parametrit ArrayListaan. Jos ID puuttuu niin se vapaa ID lisätään samalla.
     * @param lisattavanParametrit Parametrit jotka lisätään
     * @return Onnistuuko lisäys
     */
    @Override
    public boolean add(String[] lisattavanParametrit) {
        String lisattavanID = this.etsiID(lisattavanParametrit);
        if (lisattavanID == null) {
            return lisaaIlmanTunnusta(lisattavanParametrit);
        } 
        for (String[] parametrit : this) {
            if (this.etsiID(parametrit).equals(this.etsiID(lisattavanParametrit))) {
                return false;
            }
        }
        tunnukset.put(lisattavanID, lisattavanParametrit);
        return super.add(lisattavanParametrit);
        
    }
}
