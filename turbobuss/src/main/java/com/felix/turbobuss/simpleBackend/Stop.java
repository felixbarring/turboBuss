
package com.felix.turbobuss.simpleBackend;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author felix
 */
public class Stop {
    
    private final static List<String> takenNames = new ArrayList<>();
    private static int idCounter = 0;
    
    private final int ID;
    private final String name;

    private Stop(int id, String n){
        ID = id;
        name = n;
    }
    
    public static Stop createInstance(String n){
        if (takenNames.contains(n)){
            try {
                throw new Exception("Name already taken");
            } catch (Exception ex) {
                Logger.getLogger(Stop.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        } else {
            takenNames.add(n);
            return new Stop(idCounter++, n);
        }
    }
    
    public String getName(){
        return name;
    }
    
    // equals / hash methods ?
}
