/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean.newDiagnostic;

//import entities.Diseases;
import entities.ClinicalRecords;
import entities.DiagnoseStatus;
import entities.Diagnoses;
import entities.Diseases;
import entities.Patients;
import entities.Persons;
import entities.Professionals;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.component.growl.Growl;
import org.primefaces.context.RequestContext;
import sessionbeans.ClinicalRecordsFacadeLocal;
import sessionbeans.DiagnoseStatusFacadeLocal;
import sessionbeans.DiagnosesFacadeLocal;
import sessionbeans.DiseasesFacadeLocal;
import sessionbeans.PatientsFacadeLocal;
import sessionbeans.PersonsFacadeLocal;
import sessionbeans.ProfessionalsFacadeLocal;

/**
 *
 * @author Gustavo Salvo Lara
 */
@ManagedBean
@ViewScoped
public class NewDiagnostic implements Serializable {
    @EJB
    private PatientsFacadeLocal patientsFacade;
    @EJB
    private ClinicalRecordsFacadeLocal clinicalRecordsFacade;
    @EJB
    private DiagnosesFacadeLocal diagnosesFacade;
    @EJB
    private ProfessionalsFacadeLocal professionalsFacade;
    @EJB
    private PersonsFacadeLocal personsFacade;
    @EJB
    private DiagnoseStatusFacadeLocal diagnoseStatusFacade;
    @EJB
    private DiseasesFacadeLocal diseasesFacade;

    private String pathology = "";
    private String stateDiagnostic = "";
    private String comments = "";
    private String rut;
    
    private List<Diseases> diseases;

    private boolean stateGes = true;

    /**
     * Creates a new instance of NewDiagnostic
     */
    public NewDiagnostic() {

    }

    public List<String> completeTextPathology(String query) {
        System.out.println("EJECUTO");
        diseases = diseasesFacade.findAll();
        List<String> results = new ArrayList<String>();
        for (Diseases disease : diseases) {
            if (disease.getDisName().startsWith(query)) {
                results.add(disease.getDisName());
            }
        }
        return results;
    }

    public void warningGest() {
        boolean type = diseasesFacade.diseaseType(pathology);
        stateGes = true;
        if (type == true && stateDiagnostic.equals("confirmado")) {
            FacesContext.getCurrentInstance().addMessage("guau", new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia", "La patología " + pathology + " es una enfermedad GES. "));
            stateGes = false;
        }
    }

    public void resetInput() {
        this.comments = "";
        this.pathology = "";
        this.stateDiagnostic = "";
        this.stateGes = false;
        //System.out.println(pathology);
    }

    public void createDiagnostic() {
        int crecId;
        int disId;
        
        if(pathology.isEmpty()){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("guau", new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Debe ingresar una patología."));
            return;
        }
        if(stateDiagnostic.isEmpty()){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("guau", new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Debe ingresar un estado."));
            return;
        }
        if(comments.isEmpty()){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("guau", new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Debe ingresar un comentario."));
            return;
        }
        
        List<Diseases> searchDiseases = diseasesFacade.searchByName(pathology);
        if(searchDiseases.isEmpty()){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("guau", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe ingresar una patología existente."));
            return; 
        }
        disId = searchDiseases.get(0).getDisId();
        //System.out.println("Id de la enfermedad: " + disId);
        List<Persons> searchPersons = personsFacade.searchByRut(rut);
        List<Persons> searchPersons2 = personsFacade.searchByRut("17409487k");
        List<Patients> searchPatients = patientsFacade.searchById(searchPersons.get(0).getPersonId());
        List<Professionals> searchProfessionals = professionalsFacade.searchById(searchPersons2.get(0).getPersonId());
        List<ClinicalRecords> searchClinicalRecordses = clinicalRecordsFacade.searchByPerson(searchPatients.get(0));
        crecId = searchClinicalRecordses.get(0).getCrecId();
        Date fecha = new Date();

        //Otros datos
        List<DiagnoseStatus> searchDiagnoseStatus = diagnoseStatusFacade.searchByName(stateDiagnostic);
        System.out.println("Id del estatus: " + searchDiagnoseStatus.get(0).getDstatId());

        Diagnoses newDiagnoses2 = new Diagnoses();
        newDiagnoses2.setDiagId(null);
        newDiagnoses2.setCrecId(searchClinicalRecordses.get(0));
        newDiagnoses2.setDisId(searchDiseases.get(0));
        newDiagnoses2.setDstatId(searchDiagnoseStatus.get(0));
        newDiagnoses2.setPersonId(searchProfessionals.get(0));
        newDiagnoses2.setDiagDate(fecha);
        newDiagnoses2.setDiagComment(comments);
        newDiagnoses2.setEvolved(0);
        newDiagnoses2.setEvolvednext(0);
        diagnosesFacade.create(newDiagnoses2);
        FacesContext.getCurrentInstance().addMessage("guau", new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "El diagnostico se ha agregado exitosamente"));
        resetInput();
    }

    public String getPathology() {
        return pathology;
    }

    public void setPathology(String pathology) {
        this.pathology = pathology;
    }

    public String getStateDiagnostic() {
        return stateDiagnostic;
    }

    public void setStateDiagnostic(String stateDiagnostic) {
        this.stateDiagnostic = stateDiagnostic;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public boolean isStateGes() {
        return stateGes;
    }

    public void setStateGes(boolean stateGes) {
        this.stateGes = stateGes;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
    
}
