/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbeans;

import entities.ClinicalRecords;
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
public class ClinicalRecordsFacade extends AbstractFacade<ClinicalRecords> implements ClinicalRecordsFacadeLocal {
    @PersistenceContext(unitName = "com.grupouno_PingesoJBoss-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClinicalRecordsFacade() {
        super(ClinicalRecords.class);
    }
    
    @Override
    public List<ClinicalRecords> searchByPerson(Patients person) {
        Query query;
        query = em.createNamedQuery("ClinicalRecords.findByPersonId").
                setParameter("personId", person);
        return query.getResultList();
    }
}
