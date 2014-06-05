/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbeans;

import entities.DiagnoseStatus;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Joel
 */
@Local
public interface DiagnoseStatusFacadeLocal {

    void create(DiagnoseStatus diagnoseStatus);

    void edit(DiagnoseStatus diagnoseStatus);

    void remove(DiagnoseStatus diagnoseStatus);

    DiagnoseStatus find(Object id);

    List<DiagnoseStatus> findAll();

    List<DiagnoseStatus> findRange(int[] range);

    int count();
    
    public List<DiagnoseStatus> searchByName(String name);
}
