
package com.felix.main.turbobuss.model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author felix
 */
public class Stop implements Comparable<Stop> {

    private final static List<String> takenNames = new ArrayList<>();
    private static int idCounter = 0;
    private final int ID;
    private final String name;
    private final String nameLowerCase;

    // Node stuff
    private final List<Line> lines = new ArrayList<>();
    private final List<Stop> connectedStops = new ArrayList<>();
    private final List<Line> stopConnectedBy = new ArrayList<>();
    
    private ArrivalTime bestTime;
    private Line bestLine;
    private Stop previous;

    private Stop(int id, String n) {
        ID = id;
        name = n;
        nameLowerCase = name.toLowerCase();
    }
    
    static Stop createInstance(String n) {
        if (takenNames.contains(n)) {
            try {
                throw new Exception("Name already taken");
            } catch (Exception ex) {
                Logger.getLogger(Stop.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        } else {
            takenNames.add(n);
            return new Stop(idCounter++, n);
        }
    }

    public String getName() {
        return name;
    }
    
    // Must be called when all lines has been created
    void addLines(List<Line> l) {
        for (Line line : l) {
            if (line.travelsTo(this)) {
                lines.add(line);
            }
        }
    }

    void connectToNeighbors() {
        for (Line l : lines) {
            for (Stop s : l.getConnectedStops(this)) {
                connectedStops.add(s);
                stopConnectedBy.add(l);
            }
        }
    }

    List<Stop> getConnectedStops() {
        return connectedStops;
    }
       
    void setBetsTime(ArrivalTime time) {
        bestTime = time;
    }

    ArrivalTime getBestTime() {
        return bestTime;
    }
    
    void offerTime(ArrivalTime at, Line l, Stop s) {
        
        //System.out.println("---   --- " + at);
        
        if (bestTime == null || at.isSmallerThan(bestTime)) {
            bestTime = at;
            bestLine = l;
            previous = s;
        }
    }

    void setPrevious(Stop n) {
        previous = n;
    }
    
    Stop getPrevious() {
        return previous;
    }

    void computeShortestPathTo(Stop that) {
        //System.out.println("Computing shortest path between " + this.name + " " + that.name);
        for (int i = 0; i < connectedStops.size(); i++) { 
            if (connectedStops.get(i).equals(that)) {
                ArrivalTime at = stopConnectedBy.get(i).getBestArrivalTime(this.bestTime, this, that);
                if(at == null){
                    break;
                }
                that.offerTime(at, stopConnectedBy.get(i), this);
                break;
            }
        }
    }

    boolean nameMatch(String str) {
        return str.toLowerCase().equals(nameLowerCase);
    }

    public Line getLineToPrevous() {
        return bestLine;
    }

    @Override
    public boolean equals(Object o) {
        return this == o;
    }

    /**
     * Does not return 0 when the two objects are equal
     *     
     * @param that
     * @return
     */
    @Override
    public int compareTo(Stop that) {
        if (this.bestTime == null) {
            return 1;
        } else if (that.bestTime == null) {
            return -1;
        } else if (this.getBestTime().isSmallerThan(that.getBestTime())) {
            return -1;
        } else {
            return 1;
        }
    }
}
