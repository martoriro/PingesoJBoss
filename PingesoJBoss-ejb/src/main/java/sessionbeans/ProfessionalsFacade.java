/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbeans;

import entities.Professionals;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Joel
 */
@Stateless
public class ProfessionalsFacade extends AbstractFacade<Professionals> implements ProfessionalsFacadeLocal {
    @PersistenceContext(unitName = "com.grupouno_PingesoJBoss-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProfessionalsFacade() {
        super(Professionals.class);
    }
    
    @Override
    public List<Professionals> searchById(int id) {
        Query query;
        query = em.createNamedQuery("Professionals.findByPersonId").
                setParameter("personId", id);
        return query.getResultList();
    }
}
