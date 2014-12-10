
package com.felix.turbobuss.simpleBackend;

import java.util.HashMap;
import java.util.Map;

/**
 * @author felix
 */
public class Vehicle {
    
    private static int idCounter = 0;
    
    private final int ID;
    private final Map<Stop, ArrivalTime> arrivalTimes;
    
    private Vehicle(int id, HashMap<Stop, ArrivalTime> a){
        ID = id;
        arrivalTimes = a;
    }
    
    public static Vehicle createInstance(HashMap<Stop, ArrivalTime> a){
        return new Vehicle(idCounter++, a);
    }
   
    ArrivalTime getArrivalTime(Stop s){
        return arrivalTimes.get(s);
    }
    
}
