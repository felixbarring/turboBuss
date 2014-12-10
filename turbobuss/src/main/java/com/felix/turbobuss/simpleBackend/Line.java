
package com.felix.turbobuss.simpleBackend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author felix
 */
public class Line {

    private final static List<String> takenNames = new ArrayList<>();
    private static int idCounter = 0;

    private final int ID;
    private final String name;
    private final List<Stop> stops;
    private final List<Vehicle> vehicles;
      
    private Line(int id, String n, List<Stop> s){
        ID = id;
        name = n;
        stops = s;
        vehicles = new ArrayList<>();
    }
    
    public static Line createInstance(String n, List<Stop> s){
        if (takenNames.contains(n)){
            try {
                throw new Exception("Name already taken");
            } catch (Exception ex) {
                Logger.getLogger(Stop.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        } else {
            takenNames.add(n);
            return new Line(idCounter++, n, s);
        }
    }
    
    void createAndAddVehicle(HashMap<Stop, ArrivalTime> a){
        // Test so that the map is correct :3
        vehicles.add(Vehicle.createInstance(a));
    }
    
    public String getName(){
        return name;
    }
    
    public int getId(){
        return ID;
    }
    
    public List<Stop> getStops(){
        return stops;
    }
    
    public List<ArrivalTime> getArrivalTimes(Stop s){
        List<ArrivalTime> arrivalTimes = new ArrayList<>();
        for (Vehicle v : vehicles){
            ArrivalTime at = v.getArrivalTime(s);
            if (at == null){
                // Crap
            } else {
                arrivalTimes.add(at);
            }
        }
        return arrivalTimes;
    }
        
}
