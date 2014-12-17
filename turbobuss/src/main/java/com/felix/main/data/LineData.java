
package com.felix.main.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author felix
 */
public class LineData {
    
    private final String name;
    private final String nameLowerCase;
    private final String type;
    private final String typeLowerCase;
    private final String startStop;
    private final String endStop;
    
    private final List<String> stopsAtoB;
    private final List<String> stopsBtoA;
    private final Map<String, List<String>> arrivalTimesAtoB;
    private final Map<String, List<String>> arrivalTimesBtoA;
    
    public LineData(String n, String t, String start, String end, List<String> stops, 
            HashMap<String, List<String>> atAtoB, HashMap<String,List<String>> atBtoA){
        name = n;
        nameLowerCase = name.toLowerCase();
        type = t;
        typeLowerCase = type.toLowerCase();
        startStop = start;
        endStop = end;
        this.stopsAtoB = stops;
        this.stopsBtoA = reverse(stops);
        arrivalTimesAtoB = atAtoB;
        arrivalTimesBtoA = atBtoA;
    }
    
    private List<String> reverse(List<String> strings){
        List<String> result = new ArrayList<>();
        for(int i = strings.size()-1; i >= 0; i--){
            result.add(strings.get(i));
        }
        return result;
    }
    
    public String getName(){
        return name;
    }
    
    public String getType(){
        return type;
    }
    
    public String getStart(){
        return startStop;
    }
    
    public String getEnd(){
        return endStop;
    }
    
    public List<String> getStopsAtoB(){
        return stopsAtoB;
    }

    public List<String> getStopsBtoA(){
        return stopsBtoA;
    }
    
    public List<String> getArrivalTimesAtoB(String stop){
        return arrivalTimesAtoB.get(stop);
    }
    
    public List<String> getArrivalTimesBtoA(String stop){
        return arrivalTimesBtoA.get(stop);
    }
    
    public boolean acceptedByFilter(String filter){
        final String lcFilter = filter.toLowerCase();
        return nameLowerCase.equals(lcFilter) || typeLowerCase.equals(lcFilter);
    }

}
