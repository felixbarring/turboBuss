
package com.felix.turbobuss.simpleBackend;

import java.util.List;

/**
 *
 * @author felix
 */
public interface IBackend {
    
    List<Line> getLines();
    
    Line getLine(int id);
    
    void copmutePath(String startName, String endName);
    
    List<String> getStopNames();
    
}
