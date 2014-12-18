
package com.felix.turbobuss.persistence;

import com.felix.turbobuss.persistence.util.AbstractEntity;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author felix
 */
@Entity
public class Stop extends AbstractEntity {

    @Column(nullable = false)
    private String name;

    public Stop() {
    }

    public Stop(String name) {
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
