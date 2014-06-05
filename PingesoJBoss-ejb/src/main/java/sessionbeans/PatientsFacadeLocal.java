/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbeans;

import entities.Patients;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Joel
 */
@Local
public interface PatientsFacadeLocal {

    void create(Patients patients);

    void edit(Patients patients);

    void remove(Patients patients);

    Patients find(Object id);

    List<Patients> findAll();

    List<Patients> findRange(int[] range);

    int count();
    
    public List<Patients> searchById(int id);
}
