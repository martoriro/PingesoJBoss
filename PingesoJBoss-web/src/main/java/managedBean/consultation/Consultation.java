/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean.consultation;

import entities.ClinicalRecords;
import entities.DiagnoseStatus;
import entities.Diagnoses;
import entities.Diseases;
import entities.MedicalHistories;
import entities.Patients;
import entities.Persons;
import entities.Professionals;
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
import sessionbeans.MedicalHistoriesFacadeLocal;
import sessionbeans.PatientsFacadeLocal;
import sessionbeans.PersonsFacadeLocal;
import sessionbeans.ProfessionalsFacadeLocal;

/**
 *
 * @author Martín
 */
@ManagedBean
@ViewScoped
public class Consultation implements Serializable {

    @EJB
    private MedicalHistoriesFacadeLocal medicalHistoriesFacade;
    @EJB
    private ProfessionalsFacadeLocal professionalsFacade;
    @EJB
    private PatientsFacadeLocal patientsFacade;
    @EJB
    private PersonsFacadeLocal personsFacade;
    @EJB
    private DiagnoseStatusFacadeLocal diagnoseStatusFacade;
    @EJB
    private DiseasesFacadeLocal diseasesFacade;
    @EJB
    private DiagnosesFacadeLocal diagnosesFacade;
    @EJB
    private ClinicalRecordsFacadeLocal clinicalRecordsFacade;

    private List<Diseases> allDisease;
    private List<DiagnoseStatus> allDiagnoseStatus;
    private List<Diagnoses> allDiagnoses;
    private List<MedicalHistories> allMedicalHistorys;
    private String rut;
    private String patientName;
    private String textHistory;
    private boolean disableButtons = true;
    private boolean disableEndButton = true;

    private List<Patients> patients;

    public List<MedicalHistories> getAllMedicalHistorys() {
        return allMedicalHistorys;
    }

    public void setAllMedicalHistorys(List<MedicalHistories> allMedicalHistorys) {
        this.allMedicalHistorys = allMedicalHistorys;
    }

    public String getTextHistory() {
        return textHistory;
    }

    public void setTextHistory(String textHistory) {
        this.textHistory = textHistory;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
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

    public List<Diagnoses> getAllDiagnoses() {
        return allDiagnoses;
    }

    public void setAllDiagnoses(List<Diagnoses> allDiagnoses) {
        this.allDiagnoses = allDiagnoses;
    }

    public List<Patients> getPatients() {
        return patients;
    }

    public void setPatients(List<Patients> patients) {
        this.patients = patients;
    }

    public boolean isDisableButtons() {
        return disableButtons;
    }

    public void setDisableButtons(boolean disableButtons) {
        this.disableButtons = disableButtons;
    }

    public boolean isDisableEndButton() {
        return disableEndButton;
    }

    public void setDisableEndButton(boolean disableEndButton) {
        this.disableEndButton = disableEndButton;
    }
    
    public List<String> completeTextPatient(String query) {
        patients = patientsFacade.findAll();
        List<String> results = new ArrayList<String>();
        for (Patients patient : patients) {
            if (patient.getPersons().getRut().startsWith(query)) {
                results.add(patient.getPersons().getRut());
            }
        }
        return results;
    }

    public void resetInput() {
        rut = "";
        patientName = "";
        allDiagnoses = null;
        allMedicalHistorys = null;
        disableButtons = true;
        disableEndButton = true;
    }

    public void selectPatient() {
        if(rut.isEmpty()){
            FacesContext.getCurrentInstance().addMessage("wuff", new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Debe ingresar un paciente."));
            return;
        }
        List<Persons> searchPerson = personsFacade.searchByRut(rut);
        System.out.println(searchPerson);
        if(searchPerson.isEmpty()){
            FacesContext.getCurrentInstance().addMessage("wuff", new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Debe ingresar un paciente correcto."));
            return;
        }
        disableButtons = false;
        buscarPersona();
        buscarDiagnosticos();
        mostrarClinicalEvolution();
    }

    public void buscarPersona() {
        List<Persons> searchPerson = personsFacade.searchByRut(rut);
        patientName = searchPerson.get(0).getPerNames() + " " + searchPerson.get(0).getPerFathername() + " " + searchPerson.get(0).getPerMothername();
    }

    public void mostrarClinicalEvolution() {
        List<Persons> searchPerson = personsFacade.searchByRut(rut);
        List<Patients> searchPatient = patientsFacade.searchById(searchPerson.get(0).getPersonId());
        List<ClinicalRecords> searchClinicalRecord = clinicalRecordsFacade.searchByPerson(searchPatient.get(0));
        if (!searchClinicalRecord.isEmpty()) {
            allMedicalHistorys = medicalHistoriesFacade.searchByClinicalRecord(searchClinicalRecord.get(0));
        }
        
    }

    public void buscarDiagnosticos() {
        List<Persons> searchPerson = personsFacade.searchByRut(rut);
        allDisease = diseasesFacade.findAll();
        allDiagnoseStatus = diagnoseStatusFacade.findAll();

        if (searchPerson.isEmpty()) {
            allDiagnoses = null;
        } else {
            List<Patients> searchPatient = patientsFacade.searchById(searchPerson.get(0).getPersonId());
            List<ClinicalRecords> searchClinicalRecords = clinicalRecordsFacade.searchByPerson(searchPatient.get(0));
            if (!searchClinicalRecords.isEmpty()) {
                allDiagnoses = diagnosesFacade.searchByCre(searchClinicalRecords.get(0));
            }
        }
    }

    public void createClincalEvolution() {
        if(textHistory.isEmpty()){
            FacesContext.getCurrentInstance().addMessage("wuff", new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Debe ingresar historia clinica."));
            return;
        }
        Date fecha = new Date();
        List<Persons> searchPerson = personsFacade.searchByRut("17409487k");
        List<Professionals> searchProfessional = professionalsFacade.searchById(searchPerson.get(0).getPersonId());
        List<Persons> searchPerson2 = personsFacade.searchByRut(rut);
        List<Patients> searchPatients = patientsFacade.searchById(searchPerson2.get(0).getPersonId());
        List<ClinicalRecords> searchClinicalRecord = clinicalRecordsFacade.searchByPerson(searchPatients.get(0));

        MedicalHistories newMedicalHistory = new MedicalHistories();
        newMedicalHistory.setCrecId(searchClinicalRecord.get(0));
        newMedicalHistory.setMhistory(textHistory);
        newMedicalHistory.setMhysDtime(fecha);
        newMedicalHistory.setPersonId(searchProfessional.get(0));

        medicalHistoriesFacade.create(newMedicalHistory);
        textHistory = "";        
        FacesContext.getCurrentInstance().addMessage("wuff", new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "La consulta fue ingresada exitosamente."));
    }
}
