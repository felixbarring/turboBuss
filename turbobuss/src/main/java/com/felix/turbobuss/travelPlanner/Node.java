
package com.felix.turbobuss.travelPlanner;

import com.felix.turbobuss.simpleBackend.Line;
import com.felix.turbobuss.simpleBackend.Stop;
import java.util.List;

/**
 * @author felix
 */
public class Node {
    
    private final Stop stop;
    private final List<Line> lines;
    
    Node(Stop s, List<Line> l){
        stop = s;
        lines = l;
    }
    
    
    
}
