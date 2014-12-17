
package com.felix.turbobuss.modell;

import com.felix.data.LineData;
import com.felix.data.TravelRoute;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author felix
 */
public enum Backend implements IBackend{
    INSTANCE;
    
    private final List<Stop> allStops = new ArrayList<>();
    private final List<Line> allLines = new ArrayList<>();
    private final List<String> stopNames = new ArrayList<>();
    
    private final List<LineData> lineData = new ArrayList<>();
 
    private Backend(){
        Stop langrevsvagen = Stop.createInstance("Langrevsvagen");
        Stop hjalmar = Stop.createInstance("Hjalmar Brantings Platsen");
        Stop lillabommen = Stop.createInstance("Lilla Bommen");
        Stop nordstan = Stop.createInstance("Nordstaden");
        Stop jarntorget = Stop.createInstance("Jarn Torget");
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
        Line rod = Line.createInstance("Rod", Line.LineType.BUSS, rodStops);
        
        for (int i = 0; i < 18; i++){
            HashMap<Stop, ArrivalTime> v1 = new HashMap<>();
            v1.put(langrevsvagen, new ArrivalTime((short)(6 + i), (short) 0));
            v1.put(jarntorget, new ArrivalTime((short) (6 + i), (short) 20));
            v1.put(lillabommen, new ArrivalTime((short)(6 + i), (short) 25));
            v1.put(nordstan, new ArrivalTime((short) (6 + i), (short) 30));
            rod.createAndAddVehicle(v1, true);       
        }
        
        for (int i = 0; i < 18; i++){
            HashMap<Stop, ArrivalTime> v1 = new HashMap<>();
            v1.put(nordstan, new ArrivalTime((short)(6 + i), (short) 0));
            v1.put(lillabommen, new ArrivalTime((short) (6 + i), (short) 20));
            v1.put(jarntorget, new ArrivalTime((short)(6 + i), (short) 25));
            v1.put(langrevsvagen, new ArrivalTime((short) (6 + i), (short) 30));
            rod.createAndAddVehicle(v1, false);       
        }
        allLines.add(rod);
        
        List<Stop> n3Stops = new ArrayList<>();
        n3Stops.add(jarntorget);
        n3Stops.add(vasa);
        Line n3 = Line.createInstance("3", Line.LineType.TRAM, n3Stops);
        
        for (int i = 4; i < 8; i++){
            HashMap<Stop, ArrivalTime> v1 = new HashMap<>();
            v1.put(jarntorget, new ArrivalTime((short)(6 + i), (short) 0));
            v1.put(vasa, new ArrivalTime((short) (6 + i), (short) 30));
            n3.createAndAddVehicle(v1, true);       
        }
        
        for (int i = 4; i < 8; i++){
            HashMap<Stop, ArrivalTime> v1 = new HashMap<>();
            v1.put(vasa, new ArrivalTime((short)(6 + i), (short) 0));
            v1.put(jarntorget, new ArrivalTime((short) (6 + i), (short) 30));
            n3.createAndAddVehicle(v1, false);       
        }
        allLines.add(n3);
        
        
        List<Stop> n6Stops = new ArrayList<>();
        n6Stops.add(jarntorget);
        n6Stops.add(chalmers);
        Line n6 = Line.createInstance("6", Line.LineType.TRAM, n6Stops);
        
        for (int i = 0; i < 11; i++){
            HashMap<Stop, ArrivalTime> v1 = new HashMap<>();
            v1.put(jarntorget, new ArrivalTime((short)(6 + i), (short) 0));
            v1.put(chalmers, new ArrivalTime((short) (6 + i), (short) 5));
            //v1.put(jarntorget, new ArrivalTime((short)(6 + i), (short) 23));
            //v1.put(chalmers, new ArrivalTime((short) (6 + i), (short) 28));
            n6.createAndAddVehicle(v1, true);       
        }
        
        for (int i = 0; i < 11; i++){
            HashMap<Stop, ArrivalTime> v1 = new HashMap<>();
            v1.put(chalmers, new ArrivalTime((short)(6 + i), (short) 0));
            v1.put(jarntorget, new ArrivalTime((short) (6 + i), (short) 5));
            //v1.put(chalmers, new ArrivalTime((short)(6 + i), (short) 23));
            //v1.put(jarntorget, new ArrivalTime((short) (6 + i), (short) 28));
            n6.createAndAddVehicle(v1, false);       
        }
        allLines.add(n6);
        
        List<Stop> n7Stops = new ArrayList<>();
        n7Stops.add(nordstan);
        n7Stops.add(chalmers);
        Line n7 = Line.createInstance("7", Line.LineType.TRAM, n7Stops);
        
        for (int i = 0; i < 18; i++){
            HashMap<Stop, ArrivalTime> v1 = new HashMap<>();
            v1.put(nordstan, new ArrivalTime((short)(6 + i), (short) 4));
            v1.put(chalmers, new ArrivalTime((short) (6 + i), (short) 45));
            n7.createAndAddVehicle(v1, true);       
        }
        
        for (int i = 0; i < 18; i++){
            HashMap<Stop, ArrivalTime> v1 = new HashMap<>();
            v1.put(chalmers, new ArrivalTime((short)(6 + i), (short) 4));
            v1.put(nordstan, new ArrivalTime((short) (6 + i), (short) 45));
            n7.createAndAddVehicle(v1, false);       
        }
        allLines.add(n7);
        
        List<Stop> n10Stops = new ArrayList<>();
        n10Stops.add(hjalmar);
        n10Stops.add(lillabommen);
        n10Stops.add(vasa);
        n10Stops.add(chalmers);
        Line n10 = Line.createInstance("10", Line.LineType.TRAM, n10Stops);
        
        for (int i = 0; i < 18; i++){
            HashMap<Stop, ArrivalTime> v1 = new HashMap<>();
            v1.put(hjalmar, new ArrivalTime((short)(6 + i), (short) 20));
            v1.put(lillabommen, new ArrivalTime((short) (6 + i), (short) 25));
            v1.put(vasa, new ArrivalTime((short) (6 + i), (short) 30));
            v1.put(chalmers, new ArrivalTime((short) (6 + i), (short) 35));
            n10.createAndAddVehicle(v1, true);       
        }
        
        for (int i = 0; i < 18; i++){
            HashMap<Stop, ArrivalTime> v1 = new HashMap<>();
            v1.put(chalmers, new ArrivalTime((short)(6 + i), (short) 20));
            v1.put(vasa, new ArrivalTime((short) (6 + i), (short) 25));
            v1.put(lillabommen, new ArrivalTime((short) (6 + i), (short) 30));
            v1.put(hjalmar, new ArrivalTime((short) (6 + i), (short) 35));
            n10.createAndAddVehicle(v1, false);       
        }
        allLines.add(n10);
        
        List<Stop> n16Stops = new ArrayList<>();
        n16Stops.add(hjalmar);
        n16Stops.add(nordstan);
        n16Stops.add(vasa);
        n16Stops.add(chalmers);
        Line n16 = Line.createInstance("16", Line.LineType.BUSS, n16Stops);
        
        for (int i = 3; i < 16; i++){
            HashMap<Stop, ArrivalTime> v1 = new HashMap<>();
            v1.put(hjalmar, new ArrivalTime((short)(6 + i), (short) 40));
            v1.put(nordstan, new ArrivalTime((short) (6 + i), (short) 49));
            v1.put(vasa, new ArrivalTime((short) (6 + i), (short) 53));
            v1.put(chalmers, new ArrivalTime((short) (6 + i), (short) 59));
            n16.createAndAddVehicle(v1, true);       
        }
        
        for (int i = 0; i < 16; i++){
            HashMap<Stop, ArrivalTime> v1 = new HashMap<>();
            v1.put(chalmers, new ArrivalTime((short)(6 + i), (short) 40));
            v1.put(vasa, new ArrivalTime((short) (6 + i), (short) 49));
            v1.put(nordstan, new ArrivalTime((short) (6 + i), (short) 53));
            v1.put(hjalmar, new ArrivalTime((short) (6 + i), (short) 59));
            n16.createAndAddVehicle(v1, false);       
        }
        allLines.add(n16);
        
        List<Stop> n24Stops = new ArrayList<>();
        n24Stops.add(langrevsvagen);
        n24Stops.add(hjalmar);
        Line n24 = Line.createInstance("24", Line.LineType.BUSS, n24Stops);
        
        for (int i = 0; i < 18; i++){
            HashMap<Stop, ArrivalTime> v1 = new HashMap<>();
            v1.put(langrevsvagen, new ArrivalTime((short)(6 + i), (short) 30));
            v1.put(hjalmar, new ArrivalTime((short) (6 + i), (short) 55));
            n24.createAndAddVehicle(v1, true);       
        }
        
        for (int i = 0; i < 18; i++){
            HashMap<Stop, ArrivalTime> v1 = new HashMap<>();
            v1.put(hjalmar, new ArrivalTime((short)(6 + i), (short) 30));
            v1.put(langrevsvagen, new ArrivalTime((short) (6 + i), (short) 55));
            n24.createAndAddVehicle(v1, false);       
        }
        allLines.add(n24);
        
        for(Stop s : allStops){
            s.addLines(allLines);
            s.connectToNeighbors();
        }
        
        for(Stop s : allStops){
            stopNames.add(s.getName());
        }

        for(Line l : allLines){
            final List<String> stops = new ArrayList<>();
            for(Stop s : l.getStopsAtoB()){
                stops.add(s.getName());
            }
            
            final HashMap<String, List<String>> arrivalTimesAtoB = new HashMap<>();
            for(Stop s : l.getStopsAtoB()){
                List<String> atStrings = new ArrayList<>();
                for(ArrivalTime at : l.getArrivalTimesAtoB(s)){
                    atStrings.add(at.toString());
                }
                arrivalTimesAtoB.put(s.getName(), atStrings);
            }
            
            final HashMap<String, List<String>> arrivalTimesBtoA = new HashMap<>();
            for(Stop s : l.getStopsBtoA()){
                List<String> atStrings = new ArrayList<>();
                for(ArrivalTime at : l.getArrivalTimesBtoA(s)){
                    atStrings.add(at.toString());
                }
                arrivalTimesBtoA.put(s.getName(), atStrings);
            }
            
            
            lineData.add(new LineData(l.getName(), l.getType().toString(), 
                    l.getA().getName(), l.getB().getName(), stops, 
                    arrivalTimesAtoB, arrivalTimesBtoA));
        }

    }
    
    public static IBackend getInstance(){
        return INSTANCE;
    }
    
    @Override
    public List<LineData> getLineData(){
        return lineData;
    }
    
    @Override    
    public LineData getLine(String name){
        for(LineData ld : lineData){
            if (ld.getName().equals(name)){
                return ld;
            }
        }
        return null;
    }
    
    public List<Stop> getStops(){
        return allStops;
    }
    
    @Override
    public List<String> getStopNames(){
        return stopNames;
    }
    
    @Override
    public List<TravelRoute> copmutePath(String startName, String endName){
        
        
        Stop start = null;
        for(Stop s : allStops){
            if(s.nameMatch(startName)){
                start = s;
                break;
            }
        }
        Stop end = null;
        for(Stop s : allStops){
            if(s.nameMatch(endName)){
                end = s;
                break;
            }
        }
        
        if(start == null || end == null){
            try {
                throw new Exception("The name privided are not correct");
            } catch (Exception ex) {
                Logger.getLogger(Backend.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return Dijkstra.findBestRoute(new ArrivalTime((short)13, (short) 37), start, end);
    }
    
}
