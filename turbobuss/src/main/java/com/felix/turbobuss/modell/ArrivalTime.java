
package com.felix.turbobuss.modell;

/**
 * @author felix
 */

/**
 * Simple class that represents a time in hour and minutes.
 * It can be compared and has a pretty toString implementation.
 */
public class ArrivalTime {
    
    private final short hour;
    private final short minute;
    
    private final String strH;
    private final String strM;
    
    public ArrivalTime(short h, short m){

        assert(h >= 0 && h < 24);
        assert(m >= 0 && m <= 60);
        
        hour = h;
        minute = m;
        
        if (hour < 10) {
            strH = "0" + hour;
        } else {
            strH = "" + hour;
        }
        
        if (minute < 10){
            strM = "0" + minute;
        } else {
            strM = "" + minute;
        }
    }
    
    /**
     * @param that The other ArrivalTime instance that will be compared
     * @return true if this instance is later on the day, else false
     */
    public boolean isBiggerThan(ArrivalTime that){
        return this.hour * 60 + this.minute > that.hour * 60 + that.minute;
    }
    
    /**
     * 
     * @param that The other ArrivalTime instance that will be compared
     * @return true if this instance is earlier on the day, else false
     */
    public boolean isSmallerThan(ArrivalTime that){
        return this.hour * 60 + this.minute < that.hour * 60 + that.minute;
    }
    
    @Override
    public String toString(){
        return strH + ":" + strM;
    }
    
}
