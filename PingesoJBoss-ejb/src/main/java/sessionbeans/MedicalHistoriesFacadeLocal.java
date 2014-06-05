/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbeans;

import entities.ClinicalRecords;
import entities.MedicalHistories;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Joel
 */
@Local
public interface MedicalHistoriesFacadeLocal {

    void create(MedicalHistories medicalHistories);

    void edit(MedicalHistories medicalHistories);

    void remove(MedicalHistories medicalHistories);

    MedicalHistories find(Object id);

    List<MedicalHistories> findAll();

    List<MedicalHistories> findRange(int[] range);

    int count();

    List<MedicalHistories> searchByClinicalRecord(ClinicalRecords clinicalRecord);
    
}
