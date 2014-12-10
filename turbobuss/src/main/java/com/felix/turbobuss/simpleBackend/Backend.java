
package com.felix.turbobuss.simpleBackend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author felix
 */
public enum Backend implements IBackend{
    INSTANCE;
    
    private final List<Stop> allStops = new ArrayList<>();
    private final List<Line> allLines = new ArrayList<>();
 
    private Backend(){
        Stop langrevsvagen = Stop.createInstance("Långrevsvägen");
        Stop hjalmar = Stop.createInstance("Hjalmar Brantings Platsen");
        Stop lillabommen = Stop.createInstance("Lilla Bommen");
        Stop nordstan = Stop.createInstance("Nordstaden");
        Stop jarntorget = Stop.createInstance("Järn Torget");
        Stop vasa = Stop.createInstance("Vasa Platsen");
        Stop chalmers = Stop.createInstance("Chalmers");
        
        allStops.add(langrevsvagen);
        allStops.add(hjalmar);
        allStops.add(lillabommen);
        allStops.add(nordstan);
        allStops.add(jarntorget);
        allStops.add(vasa);
        allStops.add(chalmers);
        
        List<Stop> rodStops = new ArrayList<>();
        rodStops.add(langrevsvagen);
        rodStops.add(jarntorget);
        rodStops.add(lillabommen);
        rodStops.add(nordstan);
        Line rod = Line.createInstance("Röd", rodStops);
        
        HashMap<Stop, ArrivalTime> v1 = new HashMap<>();
        v1.put(langrevsvagen, new ArrivalTime((short)6, (short) 0));
        v1.put(jarntorget, new ArrivalTime((short)7, (short) 0));
        v1.put(lillabommen, new ArrivalTime((short)8, (short) 0));
        v1.put(nordstan, new ArrivalTime((short)9, (short)0));
        rod.createAndAddVehicle(v1);
        
        HashMap<Stop, ArrivalTime> v2 = new HashMap<>();
        v2.put(langrevsvagen, new ArrivalTime((short) 7, (short) 0));
        v2.put(jarntorget, new ArrivalTime((short) 8, (short) 0));
        v2.put(lillabommen, new ArrivalTime((short) 9, (short) 0));
        v2.put(nordstan, new ArrivalTime((short) 10, (short)0));
        rod.createAndAddVehicle(v2);
        allLines.add(rod);
        
        List<Stop> n3Stops = new ArrayList<>();
        n3Stops.add(jarntorget);
        n3Stops.add(vasa);
        Line n3 = Line.createInstance("3", n3Stops);
        allLines.add(n3);
        
        List<Stop> n7Stops = new ArrayList<>();
        n7Stops.add(nordstan);
        n7Stops.add(chalmers);
        Line n7 = Line.createInstance("7", n7Stops);
        allLines.add(n7);
        
        List<Stop> n10Stops = new ArrayList<>();
        n10Stops.add(hjalmar);
        n10Stops.add(lillabommen);
        n10Stops.add(chalmers);
        Line n10 = Line.createInstance("10", n10Stops);
        allLines.add(n10);
        
        List<Stop> n16Stops = new ArrayList<>();
        n16Stops.add(hjalmar);
        n16Stops.add(nordstan);
        n16Stops.add(vasa);
        n16Stops.add(chalmers);
        Line n16 = Line.createInstance("16", n16Stops);
        allLines.add(n16);
        
        List<Stop> n24Stops = new ArrayList<>();
        n24Stops.add(langrevsvagen);
        n24Stops.add(hjalmar);
        Line n24 = Line.createInstance("24", n24Stops);
        allLines.add(n24);
    }
    
    public static IBackend getInstance(){
        return INSTANCE;
    }
    
    public List<Line> getLines(){
        return allLines;
    }
    
    public Line getLine(int id){
        for (Line l : allLines){
            if (l.getId() == id){
                return l;
            }
        }
        return null;
    }
 
    
}
