package com.felix.turbobuss.persistence.util;

import javax.persistence.PrePersist;


/**
 * Separate listener class (also possible with annotations on class itself (i.e.
 * Book)
 *
 * @author hajo
 */
public class BookListener {

    @PrePersist

    private void validateTitle(Book book){
         System.out.println("Listener checking title");
        if( book.getTitle().length() > 50){
            throw new IllegalArgumentException("Title to long");
        }
    }

    //More annotaions like; @PostPersist, @PreDestroy
}
