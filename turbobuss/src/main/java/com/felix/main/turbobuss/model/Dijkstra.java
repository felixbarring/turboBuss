package com.felix.main.turbobuss.model;

import com.felix.main.data.TravelRoute;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author felix
 */
public class Dijkstra {

    public static List<TravelRoute> findBestRoute(ArrivalTime startTime, Stop start, Stop end) {
        
        List<Stop> stops = Model.INSTANCE.getStops();
        for (Stop s : stops) {
            s.setBetsTime(null);
            s.setPrevious(null);
        }
        
        start.setBetsTime(startTime);
        Queue<Stop> undetermined = new PriorityQueue<>();
        for (Stop s : stops) {
            undetermined.add(s);
        }
        
        while (!undetermined.isEmpty()) {
            Stop stop = undetermined.poll();
            for (Stop s : stop.getConnectedStops()) {
                if (undetermined.contains(s)) {
                    undetermined.remove(s);
                    stop.computeShortestPathTo(s);
                    undetermined.add(s);
                }
            }
        }
        
        List<TravelRoute> route = new ArrayList<>();
        Stop current = end;
        String previousLine = "";
        
        while (current.getPrevious() != null) {
            route.add(new TravelRoute(previousLine,
                    current.getName(), current.getBestTime().toString()));
            previousLine = current.getLineToPrevous().getName();
            current = current.getPrevious();
        }
        route.add(new TravelRoute(previousLine, start.getName(), start.getBestTime().toString()));
        reverse(route);
        return route;
    }

    private static void reverse(List<TravelRoute> tr) {
        for (int i = 0; i < tr.size() / 2; i++) {
            TravelRoute temp = tr.get(i);
            tr.set(i, (tr.get(tr.size() - 1 - i)));
            tr.set(tr.size() - 1 - i, temp);
        }
    }
}
