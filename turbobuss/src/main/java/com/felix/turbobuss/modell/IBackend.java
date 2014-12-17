
package com.felix.turbobuss.modell;

import com.felix.data.LineData;
import com.felix.data.TravelRoute;
import java.util.List;

/**
 * @author felix
 */
public interface IBackend {
    
    List<LineData> getLineData();
    
    LineData getLine(String name);
    
    List<TravelRoute> copmutePath(String startName, String endName);
    
    List<String> getStopNames();
    
}
