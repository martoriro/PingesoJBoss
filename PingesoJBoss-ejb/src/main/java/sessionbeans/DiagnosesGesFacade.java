/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbeans;

import entities.DiagnosesGes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Joel
 */
@Stateless
public class DiagnosesGesFacade extends AbstractFacade<DiagnosesGes> implements DiagnosesGesFacadeLocal {
    @PersistenceContext(unitName = "com.grupouno_PingesoJBoss-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DiagnosesGesFacade() {
        super(DiagnosesGes.class);
    }
    
}
