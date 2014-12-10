
package com.felix.turbobuss.simpleBackend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author felix
 */
public enum Backend implements IBackend{
    INSTANCE;
    
    private final List<TimeTable> timeTables;
    
    private Backend(){
        timeTables = new ArrayList<>();
        
        Stop langrevsvagen = Stop.createInstance("Långrevsvägen");
        Stop hjalmar = Stop.createInstance("Hjalmar Brantings Platsen");
        Stop lillabommen = Stop.createInstance("Lilla Bommen");
        Stop nordstan = Stop.createInstance("Nordstaden");
        Stop järntorget = Stop.createInstance("Järn Torget");
        Stop vasa = Stop.createInstance("Vasa Platsen");
        Stop chalmers = Stop.createInstance("Chalmers");
        
        Line rod = new Line("Röd");
        Line n3 = new Line("3");
        Line n7 = new Line("7");
        Line n10 = new Line("10");
        Line n16 = new Line("16");
        Line n24 = new Line("24");
        
        Map<Stop, List<String>> stopTimeMap = new HashMap<>();
        
        List<String> times = new ArrayList<>();
        times.add("13:37");
        times.add("13:37");
        times.add("13:37");
        times.add("13:37");
        times.add("13:37");
        times.add("13:37");
        times.add("13:37");
        times.add("13:37");
        times.add("13:37");
        times.add("13:37");
        
        
        
        stopTimeMap.put(langrevsvagen, times);
        timeTables.add(new TimeTable(rod, stopTimeMap));
        timeTables.add(new TimeTable(n3, stopTimeMap));
        timeTables.add(new TimeTable(n7, stopTimeMap));
        timeTables.add(new TimeTable(n10, stopTimeMap));
        timeTables.add(new TimeTable(n16, stopTimeMap));
        timeTables.add(new TimeTable(n24, stopTimeMap));
    }
    
    public static IBackend getInstance(){
        return INSTANCE;
    }
    
    // Encapsulation :o
    @Override
    public List<String> getLineNames(){
        List<String> lines = new ArrayList<>();
        for(TimeTable tt : timeTables){
            lines.add(tt.getLineName());
        }
        return lines;
    }
    
    @Override
    public TimeTable getTimeTable(String line){
        
        System.out.println("Line --- " + line);
        
        for(TimeTable tt : timeTables){
            if (tt.getLineName().equals(line)){
                return tt;
            }
        }
        return null;
    }
    
    
    
}
