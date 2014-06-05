/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean.newDiagnostic;

import entities.ClinicalRecords;
import entities.DiagnoseStatus;
import entities.Diagnoses;
import entities.Diseases;
import entities.Patients;
import entities.Persons;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import sessionbeans.ClinicalRecordsFacadeLocal;
import sessionbeans.DiagnoseStatusFacadeLocal;
import sessionbeans.DiagnosesFacadeLocal;
import sessionbeans.DiseasesFacadeLocal;
import sessionbeans.PatientsFacadeLocal;
import sessionbeans.PersonsFacadeLocal;

/**
 *
 * @author Joel
 */
@ManagedBean
@ViewScoped
public class showDiagnoses{

    @EJB
    private DiagnoseStatusFacadeLocal diagnoseStatusFacade;
    @EJB
    private DiseasesFacadeLocal diseasesFacade;
    @EJB
    private DiagnosesFacadeLocal diagnosesFacade;
    @EJB
    private PatientsFacadeLocal patientsFacade;
    @EJB
    private PersonsFacadeLocal personsFacade;
    @EJB
    private ClinicalRecordsFacadeLocal clinicalRecordsFacade;

    private List<Diagnoses> allDiagnoses;
    private String rutPatient;
    private Diagnoses selectedDiagnoses;
    private List<Patients> allPatients;
    private List<Diseases> allDisease;
    private List<DiagnoseStatus> allDiagnoseStatus;
    private List<Diagnoses> lastDiagnoses;
    private Diagnoses evolveDiagnoses;

    /**
     * Creates a new instance of showDiagnoses
     */
    public showDiagnoses() {
    }

    public List<String> completeRutPatients(String query) {
        allPatients = patientsFacade.findAll();
        List<String> results = new ArrayList<String>();
        for (Patients allPatient : allPatients) {
            if (allPatient.getPersons().getRut().startsWith(query)) {
                results.add(allPatient.getPersons().getRut());
            }
        }
        return results;
    }

    public void buscar() {
        List<Persons> searchPerson = personsFacade.searchByRut(rutPatient);
        List<Patients> allPatients = patientsFacade.findAll();
        allDisease = diseasesFacade.findAll();
        allDiagnoseStatus = diagnoseStatusFacade.findAll();

        if (searchPerson.isEmpty()) {
            allDiagnoses = null;
        } else {
            List<Patients> searchPatient = patientsFacade.searchById(searchPerson.get(0).getPersonId());
            List<ClinicalRecords> searchClinicalRecords = clinicalRecordsFacade.searchByPerson(searchPatient.get(0));
            System.out.println(searchClinicalRecords.get(0).getCrecId());

            allDiagnoses = diagnosesFacade.searchByCre(searchClinicalRecords.get(0));
        }

    }

    public void evolveDiagnoses() {
        if (selectedDiagnoses.getEvolvednext() == 0) {
            System.out.println(selectedDiagnoses.getDiagComment());
            System.out.println(selectedDiagnoses.getDisId().getDisName());
            System.out.println(selectedDiagnoses.getDstatId().getDstatName());
            Date fecha = new Date();
            List<Diseases> updateDisease = diseasesFacade.searchByName(selectedDiagnoses.getDisId().getDisName());
            List<DiagnoseStatus> updateDiagnoseStatus = diagnoseStatusFacade.searchByName(selectedDiagnoses.getDstatId().getDstatName());

            evolveDiagnoses = diagnosesFacade.searchById(selectedDiagnoses.getDiagId()).get(0);

            Diagnoses newDiagnoses3 = new Diagnoses();
            newDiagnoses3.setCrecId(selectedDiagnoses.getCrecId());
            newDiagnoses3.setDstatId(updateDiagnoseStatus.get(0));
            newDiagnoses3.setDisId(updateDisease.get(0));
            newDiagnoses3.setPersonId(selectedDiagnoses.getPersonId());
            newDiagnoses3.setDiagDate(fecha);
            newDiagnoses3.setDiagComment(selectedDiagnoses.getDiagComment());
            newDiagnoses3.setEvolved(selectedDiagnoses.getDiagId());
            newDiagnoses3.setEvolvednext(0);

            diagnosesFacade.create(newDiagnoses3);
            evolveDiagnoses.setEvolvednext(newDiagnoses3.getDiagId());
            FacesContext.getCurrentInstance().addMessage("woff", new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "Evolución ingresada exitosamente."));
            diagnosesFacade.edit(evolveDiagnoses);
        }
        else{
            FacesContext.getCurrentInstance().addMessage("woff", new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia", "Ya existe una evolución de este diagnostico."));
        }

    }

    public void lastDiagnoses() {
        if (selectedDiagnoses.getEvolved() == 0) {
            FacesContext.getCurrentInstance().addMessage("woff", new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia", "No existen mas evoluciones."));
        } else {
            lastDiagnoses = diagnosesFacade.searchByEvolved(selectedDiagnoses.getEvolved());
            selectedDiagnoses = lastDiagnoses.get(0);
        }
    }

    public void nextDiagnoses() {
        if (selectedDiagnoses.getEvolvednext() == 0) {
            FacesContext.getCurrentInstance().addMessage("woff", new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia", "No existen mas evoluciones."));
        } else {
            lastDiagnoses = diagnosesFacade.searchByEvolved(selectedDiagnoses.getEvolvednext());
            selectedDiagnoses = lastDiagnoses.get(0);
        }
    }

    public List<Diagnoses> getAllDiagnoses() {
        return allDiagnoses;
    }

    public void setAllDiagnoses(List<Diagnoses> allDiagnoses) {
        this.allDiagnoses = allDiagnoses;
    }

    public String getRutPatient() {
        return rutPatient;
    }

    public void resetInput() {
        this.rutPatient = "";
        this.allDiagnoses = null;
    }

    public void setRutPatient(String rutPatient) {
        this.rutPatient = rutPatient;
    }

    public Diagnoses getSelectedDiagnoses() {
        return selectedDiagnoses;
    }

    public void setSelectedDiagnoses(Diagnoses selectedDiagnoses) {
        this.selectedDiagnoses = selectedDiagnoses;
    }

    public List<Diseases> getAllDisease() {
        return allDisease;
    }

    public void setAllDisease(List<Diseases> allDisease) {
        this.allDisease = allDisease;
    }

    public List<DiagnoseStatus> getAllDiagnoseStatus() {
        return allDiagnoseStatus;
    }

    public void setAllDiagnoseStatus(List<DiagnoseStatus> allDiagnoseStatus) {
        this.allDiagnoseStatus = allDiagnoseStatus;
    }

}
