/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbeans;

import entities.Patients;
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
public class PatientsFacade extends AbstractFacade<Patients> implements PatientsFacadeLocal {
    @PersistenceContext(unitName = "com.grupouno_PingesoJBoss-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PatientsFacade() {
        super(Patients.class);
    }
    
    @Override
    public List<Patients> searchById(int id) {
        Query query;
        query = em.createNamedQuery("Patients.findByPersonId").
                setParameter("personId", id);
        return query.getResultList();
    }
}
