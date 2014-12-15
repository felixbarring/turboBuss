
package com.felix.turbobuss.simpleBackend;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;



/**
 * @author felix
 */
public class Graph {
    
    public static void findBestRoute(ArrivalTime startTime, Stop start, Stop end){
        List<Stop> stops = Backend.INSTANCE.getStops();
        
        for (Stop s : stops){
            s.setBetsTime(null);
            s.setPrevious(null);
        }
        
        start.setBetsTime(startTime);
        System.out.println("Start node is " + start.getName() + " with start time : " + startTime);
        
        Queue<Stop> undetermined = new PriorityQueue<>();
        for(Stop s : stops){
            undetermined.add(s);
        }
        
        while(!undetermined.isEmpty()){
            Stop stop = undetermined.poll();
            System.out.println("Best time for " + stop.getName() + " has been detemined with best time " + stop.getBestTime());
            for(Stop s : stop.getConnectedStops()){
                if(undetermined.contains(s)){
                    undetermined.remove(s);
                    System.out.println("--- Stop " + s.getName() + " is connected with " + stop.getName());
                    stop.computeShortestPathTo(s);
                    undetermined.add(s);
                }
            }
        }
        
        
        
    }
    
}
