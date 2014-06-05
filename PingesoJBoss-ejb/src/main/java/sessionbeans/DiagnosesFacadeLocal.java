/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbeans;

import entities.ClinicalRecords;
import entities.Diagnoses;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Joel
 */
@Local
public interface DiagnosesFacadeLocal {

    void create(Diagnoses diagnoses);

    void edit(Diagnoses diagnoses);

    void remove(Diagnoses diagnoses);

    Diagnoses find(Object id);

    List<Diagnoses> findAll();

    List<Diagnoses> findRange(int[] range);

    int count();
    
    public List<Diagnoses> searchByCre(ClinicalRecords crecId);

    List<Diagnoses> searchByEvolved(int evolved);

    List<Diagnoses> searchById(int diagId);
}
