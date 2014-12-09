
package com.felix.turbobuss.simpleBackend;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author felix
 */
public class TimeTable {
    
    private final Line line;
    private final List<Stop> stops;
    private final Map<Stop, List<String>> arrivalTimes;
    
    TimeTable(Line l, Map<Stop, List<String>> at){
        line = l;
        arrivalTimes = at;        
        stops = new ArrayList<>();
        for(Stop stop : arrivalTimes.keySet()){
            stops.add(stop);
        } 
    }
    
    public String getLineName(){
        return line.getName();
    }
    
    
    public List<Stop> getStops(){
        return stops;
    }
    
    // Maybe return a deep copy?
    // Breaks encapsulation.
    public List<String> getArrivalTimes(Stop s){
        List<String> timesForStop = arrivalTimes.get(s);
        if(timesForStop == null){
            try {
                throw new Exception("Stop does not exist");
            } catch (Exception ex) {
                Logger.getLogger(TimeTable.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        return timesForStop;
    }
    
    public void addTime(Stop s, String time){
        List<String> timesForStop = arrivalTimes.get(s);
        if(timesForStop == null){
            try {
                throw new Exception("Stop does not exist");
            } catch (Exception ex) {
                Logger.getLogger(TimeTable.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if(timesForStop.contains(time)){
            arrivalTimes.get(s).add(time);
        } else {
            try {
                throw new Exception("Time already exist");
            } catch (Exception ex) {
                Logger.getLogger(TimeTable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void removeTime(Stop s, String time){
        List<String> timesForStop = arrivalTimes.get(s);
        if(timesForStop == null){
            try {
                throw new Exception("Stop does not exist");
            } catch (Exception ex) {
                Logger.getLogger(TimeTable.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if(timesForStop.contains(time)){
            timesForStop.remove(time);
        } else {
            try {
                throw new Exception("Time does not exist");
            } catch (Exception ex) {
                Logger.getLogger(TimeTable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
  
    
}
