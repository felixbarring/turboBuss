
package com.felix.turbobuss.travelPlanner;

import com.felix.turbobuss.simpleBackend.Backend;
import com.felix.turbobuss.simpleBackend.Stop;
import java.util.HashSet;
import java.util.Set;

/**
 * @author felix
 */
public class Graph {
    
    private static Graph instance;
    
    private final Set<Node> nodes = new HashSet<>();
    
    private Graph(){
        for (Stop s : Backend.INSTANCE.getStops()){
            nodes.add(new Node(s));
        }
        
        for (Node n : nodes){
            n.connectToNeighbors(nodes);
        }
    }
    
    public static Graph getInstance(){
        if (instance == null){
            instance = new Graph();
        }
        return instance;
    }
    
    
}
