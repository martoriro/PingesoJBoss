/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbeans;

import entities.DiagnosesGes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Joel
 */
@Local
public interface DiagnosesGesFacadeLocal {

    void create(DiagnosesGes diagnosesGes);

    void edit(DiagnosesGes diagnosesGes);

    void remove(DiagnosesGes diagnosesGes);

    DiagnosesGes find(Object id);

    List<DiagnosesGes> findAll();

    List<DiagnosesGes> findRange(int[] range);

    int count();
    
}
