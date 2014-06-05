/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbeans;

import entities.DiagnoseStatus;
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
public class DiagnoseStatusFacade extends AbstractFacade<DiagnoseStatus> implements DiagnoseStatusFacadeLocal {
    @PersistenceContext(unitName = "com.grupouno_PingesoJBoss-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DiagnoseStatusFacade() {
        super(DiagnoseStatus.class);
    }
 
    @Override
    public List<DiagnoseStatus> searchByName(String name) {
        Query query;
        query = em.createNamedQuery("DiagnoseStatus.findByDstatName").
                setParameter("dstatName", name);
        return query.getResultList();
    }
}
