package com.felix.turbobuss.persistence.util;

import javax.persistence.Column;
import javax.persistence.Entity;


/**
 * An Author
 * @author hajo
 *
 */
@Entity
public class Author extends AbstractEntity  {

    @Column(nullable = false)
    private String name;

    public Author() {
    }

    public Author(String name) {
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
