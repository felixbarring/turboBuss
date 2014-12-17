
package com.felix.main.turbobuss.model;

import com.felix.main.data.LineData;
import com.felix.main.data.TravelRoute;
import java.util.List;

/**
 * @author felix
 */

/**
 * 
 * This interface is the entire API towards the model package
 */
public interface IModel {
    
    List<LineData> getLineData();
    
    LineData getLine(String name);
    
    List<TravelRoute> copmutePath(String time, String startName, String endName);
    
    List<String> getStopNames();
    
}
