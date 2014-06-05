/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbeans;

import entities.Diseases;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Joel
 */
@Local
public interface DiseasesFacadeLocal {

    void create(Diseases diseases);

    void edit(Diseases diseases);

    void remove(Diseases diseases);

    Diseases find(Object id);

    List<Diseases> findAll();

    List<Diseases> findRange(int[] range);

    int count();
    
    public boolean diseaseType(String nombre);
    
    public List<Diseases> searchByName(String nombre);
}
