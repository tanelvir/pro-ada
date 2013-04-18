/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bibtex;

import java.util.ArrayList;

/**
 *
 * @author anttkaik
 */
public class TyyppiArrayList extends ArrayList<String[]> {

    public TyyppiArrayList() {
        //this = new ArrayList<String[]>();
    }
    
    
    
    
    private static String etsiID(String[] parametrit) {
        for (String parametri : parametrit) {
            if (parametri.toLowerCase().startsWith("id@")) {
                return parametri.substring(3); 
            }
        }
        return null;
    }
    
    //private String 
    
    @Override
    public boolean add(String[] element) {
        if (this.etsiID(element) == null) return false;
        for (String[] parametrit : this) {
            if (this.etsiID(parametrit).equals(this.etsiID(element))) {
                return false;
            }
        }
        super.add(element);
        return true;
        
    }
}
