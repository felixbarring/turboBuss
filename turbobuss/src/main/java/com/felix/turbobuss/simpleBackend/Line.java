
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
    
    public enum LineType{
        BUSS, TRAM, BOAT
    }

    private final static List<String> takenNames = new ArrayList<>();
    private static int idCounter = 0;

    private final int ID;
    private final String name;
    private final String nameLowerCase;
    private final LineType type;
    private final String typeLowerCase;
    private final List<Stop> stops;
    private final List<Vehicle> vehicles;
      
    private Line(int id, String n, LineType t, List<Stop> s){
        ID = id;
        name = n;
        nameLowerCase = name.toLowerCase();
        type = t;
        typeLowerCase = type.toString().toLowerCase();
        stops = s;
        vehicles = new ArrayList<>();
    }
    
    static Line createInstance(String n, LineType t, List<Stop> s){
        if (takenNames.contains(n)){
            try {
                throw new Exception("Name already taken");
            } catch (Exception ex) {
                Logger.getLogger(Stop.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        } else {
            takenNames.add(n);
            return new Line(idCounter++, n, t, s);
        }
    }
    
    void createAndAddVehicle(HashMap<Stop, ArrivalTime> a){
        // Test so that the map is correct :3
        vehicles.add(Vehicle.createInstance(a));
    }
    
    public int getId(){
        return ID;
    }
    
    public String getName(){
        return name;
    }
    
    public LineType getType(){
        return type;
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
  
    public boolean acceptedByFilter(String filter){
        final String lcFilter = filter.toLowerCase();
        return nameLowerCase.equals(lcFilter) || typeLowerCase.equals(lcFilter);
    }
    
}
