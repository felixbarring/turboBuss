package com.felix.turbobuss.persistence.util;

import javax.persistence.Column;
import javax.persistence.Entity;


/**
 * An Author
 * @author hajo
 *
 */
@Entity
public class Guest extends AbstractEntity  {

    @Column(nullable = false)
    private String name;

    public Guest() {
    }

    public Guest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  
    @Override
    public String toString() {
        return " - Guest with " + "id=" + getId() + " and name " + name + " - ";
    }

}
