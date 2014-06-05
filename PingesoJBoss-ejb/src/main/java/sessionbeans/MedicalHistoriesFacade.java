/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbeans;

import entities.ClinicalRecords;
import entities.MedicalHistories;
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
public class MedicalHistoriesFacade extends AbstractFacade<MedicalHistories> implements MedicalHistoriesFacadeLocal {
    @PersistenceContext(unitName = "com.grupouno_PingesoJBoss-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MedicalHistoriesFacade() {
        super(MedicalHistories.class);
    }

    @Override
    public List<MedicalHistories> searchByClinicalRecord(ClinicalRecords clinicalRecord) {
        Query query;
        query = em.createNamedQuery("MedicalHistories.findByCrecId").
                setParameter("crecId", clinicalRecord);
        return query.getResultList();
    }
    
    
}
