/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean.newDiagnostic;

import entities.ClinicalRecords;
import entities.MedicalHistories;
import entities.Patients;
import entities.Persons;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sessionbeans.ClinicalRecordsFacadeLocal;
import sessionbeans.MedicalHistoriesFacadeLocal;
import sessionbeans.PatientsFacadeLocal;
import sessionbeans.PersonsFacadeLocal;

/**
 *
 * @author Joel
 */
@ManagedBean
@ViewScoped
public class showClinicalEvolution{
    @EJB
    private PersonsFacadeLocal personsFacade;
    @EJB
    private MedicalHistoriesFacadeLocal medicalHistoriesFacade;
    @EJB
    private ClinicalRecordsFacadeLocal clinicalRecordsFacade;
    @EJB
    private PatientsFacadeLocal patientsFacade;

   
    private List<MedicalHistories> allMedicalHistorys;
    private String rutPatient;
    private MedicalHistories selectedMedicalHistory;

    /**
     * Creates a new instance of showClinicalEvolution
     */
    public showClinicalEvolution() {
    }

    public void resetInput() {
        this.rutPatient = "";
        this.allMedicalHistorys = null;
    }

    public List<String> completeRutPatients(String query) {
        List<Patients> allPatients = patientsFacade.findAll();;
        List<String> results = new ArrayList<String>();
        for (Patients allPatient : allPatients) {
            if (allPatient.getPersons().getRut().startsWith(query)) {
                results.add(allPatient.getPersons().getRut());
            }
        }
        return results;
    }

    public void mostrarClinicalEvolution() {
        List<Persons> searchPerson = personsFacade.searchByRut(rutPatient);
        List<Patients> searchPatient = patientsFacade.searchById(searchPerson.get(0).getPersonId());
        List<ClinicalRecords> searchClinicalRecord = clinicalRecordsFacade.searchByPerson(searchPatient.get(0));
        allMedicalHistorys = medicalHistoriesFacade.searchByClinicalRecord(searchClinicalRecord.get(0));
        System.out.println(rutPatient);
    }

    public String getRutPatient() {
        return rutPatient;
    }

    public void setRutPatient(String rutPatient) {
        this.rutPatient = rutPatient;
    }

    public List<MedicalHistories> getAllMedicalHistorys() {
        return allMedicalHistorys;
    }

    public void setAllMedicalHistorys(List<MedicalHistories> allMedicalHistorys) {
        this.allMedicalHistorys = allMedicalHistorys;
    }

    public MedicalHistories getSelectedMedicalHistory() {
        return selectedMedicalHistory;
    }

    public void setSelectedMedicalHistory(MedicalHistories selectedMedicalHistory) {
        this.selectedMedicalHistory = selectedMedicalHistory;
    }

}
