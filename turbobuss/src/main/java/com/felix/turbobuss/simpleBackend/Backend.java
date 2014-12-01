
package com.felix.turbobuss.simpleBackend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author felix
 */
public class Backend implements IBackend{
    
    private final List<TimeTable> timeTables;
    
    private Backend(){
        
        timeTables = new ArrayList<>();
        
        
        Line rod = new Line("Röd");
        Stop langrevsvagen = new Stop("Långrevsvägen");
        
        Map<Stop, List<String>> stopTimeMap = new HashMap<>();
        List<String> times = new ArrayList<>();
        times.add("13:37");
        times.add("14:24");
        
        stopTimeMap.put(langrevsvagen, times);
        
        timeTables.add(new TimeTable(rod, stopTimeMap));
    }
    
    public static IBackend newInstance(){
        return new Backend();
    }
    
    @Override
    public List<TimeTable> getTimeTables(){
        return timeTables;
    }
    
}
