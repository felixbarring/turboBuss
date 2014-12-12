
package com.felix.turbobuss.travelPlanner;

import com.felix.turbobuss.simpleBackend.Backend;
import com.felix.turbobuss.simpleBackend.Line;
import com.felix.turbobuss.simpleBackend.Stop;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author felix
 */
public class Node {
       
    private final Stop stop;
    private final List<Line> lines = new ArrayList<>();
    private final List<Node> connectedNodes = new ArrayList();
        
    Node(Stop s){
        stop = s;
        for (Line l : Backend.INSTANCE.getLines()){
            if (l.travelsTo(stop)){
                lines.add(l);
            }
        }
    }
    
    void connectToNeighbors(Set<Node> nodes){
        System.out.println("--");
        System.out.println("Node with stop " + stop.getName());
        for(Line l : lines){
            System.out.println("---Line " + l.getName());
            for(Stop s : l.getConnecteStops(stop)){
                System.out.println("------Connected stop " + s.getName());
               for (Node n : nodes){
                   if (n.stop.equals(s) && !connectedNodes.contains(n)){
                       //System.out.println("---------Node with stop " + stop.getName() + " was connected with node with stop " + n.stop.getName());
                       connectedNodes.add(n);
                   }
               }
            }
        }
    }
    
    
    
}
