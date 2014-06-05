/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbeans;

import entities.Professionals;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Joel
 */
@Local
public interface ProfessionalsFacadeLocal {

    void create(Professionals professionals);

    void edit(Professionals professionals);

    void remove(Professionals professionals);

    Professionals find(Object id);

    List<Professionals> findAll();

    List<Professionals> findRange(int[] range);

    int count();
    
    public List<Professionals> searchById(int id);
}
