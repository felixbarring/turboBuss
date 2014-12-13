
package com.felix.turbobuss.simpleBackend;

/**
 * @author felix
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
    
    public boolean isBiggerThan(ArrivalTime that){
        return this.hour * 60 + this.minute > that.hour * 60 + that.minute;
    }
    
    public boolean isSmallerThan(ArrivalTime that){
        return this.hour * 60 + this.minute < that.hour * 60 + that.minute;
    }
    
    @Override
    public String toString(){
        return strH + ":" + strM;
    }
    
}
