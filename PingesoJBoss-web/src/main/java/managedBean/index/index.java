/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBean.index;


import entities.Persons;
import entities.Professionals;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.context.RequestContext;
import sessionbeans.PersonsFacadeLocal;

/**
 *
 * @author Gustavo Salvo Lara
 */
@ManagedBean(name = "index")
@RequestScoped
public class index {
    @EJB
    private PersonsFacadeLocal personsFacade;
    
    private String doctorName = "Joel Avalos Pincheira";
    
    public void doctorName(){
        List<Persons> searchPerson = personsFacade.searchByRut("17409487k");
        doctorName = searchPerson.get(0).getPerNames()+" "+searchPerson.get(0).getPerFathername();
    }
    
    public void close(){
    }
    
    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
    
    public index() {
    }
    
}
