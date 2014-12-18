
package com.felix.turbobuss.persistence;

import com.felix.turbobuss.persistence.util.AbstractEntity;
import javax.persistence.Column;
import javax.persistence.Entity;


/**
 *
 * @author fubuntu
 */
@Entity
public class Line extends AbstractEntity {
    @Column(nullable = false)
    private String name;

    public Line() {
    }

    public Line(String name) {
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
        return "Author{" + "id=" + getId() + ", name=" + name + '}';
    }
    
    
}
