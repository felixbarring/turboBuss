
package com.felix.turbobuss.simpleBackend;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author felix
 */
public class Dijkstra {
    
    public static List<TravelRoute> findBestRoute(ArrivalTime startTime, Stop start, Stop end){
        List<Stop> stops = Backend.INSTANCE.getStops();
        
        for (Stop s : stops){
            s.setBetsTime(null);
            s.setPrevious(null);
        }
        
        start.setBetsTime(startTime);
        
        Queue<Stop> undetermined = new PriorityQueue<>();
        for(Stop s : stops){
            undetermined.add(s);
        }
        
        while(!undetermined.isEmpty()){
            Stop stop = undetermined.poll();
            //System.out.println("Best time for " + stop.getName() + " has been detemined with best time " + stop.getBestTime());
            for(Stop s : stop.getConnectedStops()){
                if(undetermined.contains(s)){
                    undetermined.remove(s);
                    //System.out.println("--- Stop " + s.getName() + " is connected with " + stop.getName());
                    stop.computeShortestPathTo(s);
                    undetermined.add(s);
                }
            }
        }      
        
        List<TravelRoute> route = new ArrayList<>();
        Stop current = end;
        String previousLine = "";
        while(current.getPreviouse() != null){
            route.add(new TravelRoute(previousLine, 
                    current.getName(), current.getBestArrivalTime().toString()));
            previousLine = current.getLineToPrevous().getName();
            current = current.getPreviouse();
        }
        route.add(new TravelRoute(previousLine, start.getName(), start.getBestArrivalTime().toString()));
        reverse(route);
        
        return route;
    }
    
    private static void reverse(List<TravelRoute> tr){ 
        for(int i = 0; i < tr.size()/2; i++){
            TravelRoute temp = tr.get(i);
            tr.set(i, (tr.get(tr.size()-1-i)));
            tr.set(tr.size()-1-i, temp);
        }
    }
}
