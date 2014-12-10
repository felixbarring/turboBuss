
package com.felix.turbobuss.simpleBackend;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author felix
 */
public class Stop {
    
    private final String name;
    private static List<String> takenNames = new ArrayList<>();
    
    private Stop(String n){
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
            return new Stop(n);
        }
    }
    
    public String getName(){
        return name;
    }
    
    // equals / hash methods ?
}
