/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbeans;

import entities.ClinicalRecords;
import entities.Diagnoses;
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
public class DiagnosesFacade extends AbstractFacade<Diagnoses> implements DiagnosesFacadeLocal {
    @PersistenceContext(unitName = "com.grupouno_PingesoJBoss-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DiagnosesFacade() {
        super(Diagnoses.class);
    }
    
    @Override
    public List<Diagnoses> searchByCre(ClinicalRecords crecId) {
        Query query;
        query = em.createNamedQuery("Diagnoses.findByCrecId").
                setParameter("crecId", crecId);
    
        return query.getResultList();
    }

    @Override
    public List<Diagnoses> searchByEvolved(int evolved) {
        Query query;
        query = em.createNamedQuery("Diagnoses.findByDiagId").
                setParameter("diagId", evolved);
        return query.getResultList();
    }

    @Override
    public List<Diagnoses> searchById(int diagId) {
        Query query;
        query = em.createNamedQuery("Diagnoses.findByDiagId").
                setParameter("diagId", diagId);
        return query.getResultList();
    }
    
    
    
    
}
