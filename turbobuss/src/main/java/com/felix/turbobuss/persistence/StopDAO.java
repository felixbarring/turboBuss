
package com.felix.turbobuss.persistence;

import com.felix.turbobuss.persistence.util.AbstractDAO;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fubuntu
 */
public class StopDAO extends AbstractDAO<Stop, Long>{
    
    @PersistenceContext
    private EntityManager em;

    public StopDAO() {
        super(Stop.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
    
}
