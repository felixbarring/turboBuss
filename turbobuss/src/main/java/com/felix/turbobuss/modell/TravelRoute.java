
package com.felix.turbobuss.modell;

/**
 * @author felix
 */
public class TravelRoute {
    
    private final String line;
    private final String stop;
    private final String arrivalTime;
    
    TravelRoute(String l, String s, String at){
        line = l;
        stop = s;
        arrivalTime = at;
    }
    
    public String getLine(){
        return line;
    }
    
    public String getStop(){
        return stop;
    }
    
    public String getArrivalTime(){
        return arrivalTime;
    }
    
}
