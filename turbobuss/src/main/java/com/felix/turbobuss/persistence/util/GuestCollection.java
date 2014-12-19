
package com.felix.turbobuss.persistence.util;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * DAO for books
 *
 * @author hajo
 */

@Stateless
public class GuestCollection extends AbstractDAO<Guest, Long> {

    @PersistenceContext
    private EntityManager em;

    public GuestCollection() {
        super(Guest.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
        
}
