/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbeans;

import entities.ClinicalRecords;
import entities.Patients;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Joel
 */
@Local
public interface ClinicalRecordsFacadeLocal {

    void create(ClinicalRecords clinicalRecords);

    void edit(ClinicalRecords clinicalRecords);

    void remove(ClinicalRecords clinicalRecords);

    ClinicalRecords find(Object id);

    List<ClinicalRecords> findAll();

    List<ClinicalRecords> findRange(int[] range);

    int count();
    
    public List<ClinicalRecords> searchByPerson(Patients person);
}
