
package com.felix.turbobuss.modell;

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
    private final List<Stop> stopsAtoB;
    private final List<Stop> stopsBtoA;
    private final List<Vehicle> vehiclesAtoB;
    private final List<Vehicle> vehiclesBtoA;
      
    private Line(int id, String n, LineType t, List<Stop> s){
        ID = id;
        name = n;
        nameLowerCase = name.toLowerCase();
        type = t;
        typeLowerCase = type.toString().toLowerCase();
        stopsAtoB = s;
        stopsBtoA = reverse(stopsAtoB);
        vehiclesAtoB = new ArrayList<>();
        vehiclesBtoA = new ArrayList<>();
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
    
    void createAndAddVehicle(HashMap<Stop, ArrivalTime> a, boolean fromAtoB){
        // Test so that the map is correct :3
        if (fromAtoB){
            vehiclesAtoB.add(Vehicle.createInstance(a));
        } else {
            vehiclesBtoA.add(Vehicle.createInstance(a));
        }
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
    
    public List<Stop> getStopsAtoB(){
        return stopsAtoB;
    }
    
    public List<Stop> getStopsBtoA(){
        return stopsBtoA;
    }
    
    // 
    public List<ArrivalTime> getArrivalTimesAtoB(Stop s){
        List<ArrivalTime> arrivalTimes = new ArrayList<>();
        for (Vehicle v : vehiclesAtoB){
            ArrivalTime at = v.getArrivalTime(s);
            if (at == null){
                // Crap
            } else {
                arrivalTimes.add(at);
            }
        }
        return arrivalTimes;
    }  
    
    public List<ArrivalTime> getArrivalTimesBtoA(Stop s){
        List<ArrivalTime> arrivalTimes = new ArrayList<>();
        for (Vehicle v : vehiclesBtoA){
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
    
    private List<Stop> reverse(List<Stop> list){
        List<Stop> reversedList = new ArrayList<>();
        for(int i = list.size()-1; i >= 0; i--){
            reversedList.add(list.get(i));
        }
        return reversedList;
    }
    
    public boolean travelsTo(Stop s){
        return stopsAtoB.contains(s);
    }
    
    public List<Stop> getConnectedStops(Stop s){
        List<Stop> result = new ArrayList<>();
        final int size = stopsAtoB.size();
        for (int i = 0; i < size; i++){
            if (stopsAtoB.get(i).equals(s)){
                if (i-1 >= 0){
                    result.add(stopsAtoB.get(i-1));
                } 
                if (i+1 < size){
                    result.add(stopsAtoB.get(i+1));
                }
            }
        }
        return result;
    }
     
    private ArrivalTime helper(List<Vehicle> vehicles, ArrivalTime laterThan, Stop start, Stop end){
        // Find all vehicles that leaves from the start after 'latherThan'
        List<Vehicle> candidates = new ArrayList<>();
        for (Vehicle v : vehicles){
            System.out.println(" --- " + v.getArrivalTime(start) );
            if (v.getArrivalTime(start).isBiggerThan(laterThan)){
                candidates.add(v);
            }
        }
        if(candidates.isEmpty()){
            return null;
        }
        
        System.out.println("Candidate Size" + candidates.size());

        // For these vehicles, find the one that arrive first at the end.
        // This is the optimal vehicle
        ArrivalTime optimalTime = null;
        for(Vehicle v : candidates){
            if (optimalTime == null){
                optimalTime = v.getArrivalTime(end);
            } else {
                if(v.getArrivalTime(end).isSmallerThan(optimalTime)){
                    optimalTime = v.getArrivalTime(end);
                }
            }
        }
        return optimalTime;
    }
    
    
    public ArrivalTime getBestArrivalTime(ArrivalTime laterThan, Stop start, Stop end){
        
        final int size = stopsAtoB.size();
        for(int i = 0; i < size; i++){
            if(stopsAtoB.get(i).equals(start)){
                if(i+1 < size && stopsAtoB.get(i+1).equals(end)){
                    return helper(vehiclesAtoB, laterThan, start, end);
                } else if (i-1 >= 0 && stopsAtoB.get(i-1).equals(end)){
                    return helper(vehiclesBtoA, laterThan, start, end);
                }
            }
        }
        return null;
    }
    
}
