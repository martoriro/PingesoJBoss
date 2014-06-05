/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbeans;

import entities.Persons;
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
public class PersonsFacade extends AbstractFacade<Persons> implements PersonsFacadeLocal {
    @PersistenceContext(unitName = "com.grupouno_PingesoJBoss-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonsFacade() {
        super(Persons.class);
    }
    
    @Override
    public List<Persons> searchByRut(String rut) {
        Query query;
        query = em.createNamedQuery("Persons.findByRut").
                setParameter("rut", rut);
        return query.getResultList();
    }
}
