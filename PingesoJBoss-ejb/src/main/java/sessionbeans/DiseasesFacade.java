/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbeans;

import entities.Diseases;
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
public class DiseasesFacade extends AbstractFacade<Diseases> implements DiseasesFacadeLocal {
    @PersistenceContext(unitName = "com.grupouno_PingesoJBoss-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DiseasesFacade() {
        super(Diseases.class);
    }
    
    /**
     * @Funcion que retorna si una enfermedad es GES o no
     * @param nombre
     * @return true or false
     */
    @Override
    public boolean diseaseType(String nombre) {
        boolean Result = false;
        List<Diseases> disease;
        Query query;
        query = em.createNamedQuery("Diseases.findByDisName").
                setParameter("disName", nombre);

        disease = query.getResultList();

        if (disease.isEmpty()) {
            return false;
        } else {
            Result = disease.get(0).getDisGes();
            return Result;
        }
    }

    @Override
    public List<Diseases> searchByName(String nombre) {
        Query query;
        query = em.createNamedQuery("Diseases.findByDisName").
                setParameter("disName", nombre);
        return query.getResultList();
    }
}
