/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean.newDiagnosesGes;

import entities.ClinicalRecords;
import entities.Diagnoses;
import entities.DiagnosesGes;
import entities.Patients;
import entities.Persons;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sessionbeans.ClinicalRecordsFacadeLocal;
import sessionbeans.DiagnosesFacadeLocal;
import sessionbeans.DiagnosesGesFacadeLocal;
import sessionbeans.PatientsFacadeLocal;
import sessionbeans.PersonsFacadeLocal;

/**
 *
 * @author Joel
 */
@ManagedBean
@ViewScoped
public class newDiagnosesGes {

    @EJB
    private PersonsFacadeLocal personsFacade;
    @EJB
    private PatientsFacadeLocal patientsFacade;
    @EJB
    private ClinicalRecordsFacadeLocal clinicalRecordsFacade;
    @EJB
    private DiagnosesFacadeLocal diagnosesFacade;
    @EJB
    private DiagnosesGesFacadeLocal diagnosesGesFacade;

    private String problemAuge;
    private String subProblemAuge;
    private String diagnosesGesComment;
    private String diagnosesGesBasis;
    private String treatment;
    private Date fecha;
    private boolean checkGes;
    private Diagnoses selectedDiagnoses;
    private List<Diagnoses> gesList;
    private List<ClinicalRecords> gestListCR;
    private List<Patients> gesListPA;
    private List<Persons> gesListPER;
    private List<Diagnoses> gesListDGES;
    private String rutPatient;

    public List<Diagnoses> getGesList() {
        return gesList;
    }

    public void setGesList(List<Diagnoses> gesList) {
        this.gesList = gesList;
    }

    /**
     * Creates a new instance of newDiagnosesGes
     */
    public newDiagnosesGes() {
    }

    public void createDiagnosesGes() {
        //datos de prueba
        gesListPER = personsFacade.searchByRut("69727697");
        gesListPA = patientsFacade.searchById(gesListPER.get(0).getPersonId());
        gestListCR = clinicalRecordsFacade.searchByPerson(gesListPA.get(0));
        gesList = diagnosesFacade.searchByCre(gestListCR.get(0));
    
        problemAuge = "prueba 1";
        subProblemAuge = "prueba2";
        diagnosesGesComment = "prueba3";
        diagnosesGesBasis = "prueba 4";
        treatment = "prueba 5";
        fecha = new Date();
        checkGes = true;
        selectedDiagnoses = diagnosesFacade.searchById(1).get(0);

        DiagnosesGes newDiagnosesGes = new DiagnosesGes();

        newDiagnosesGes.setProblemAuge(problemAuge);
        newDiagnosesGes.setSubproblemAuge(subProblemAuge);
        newDiagnosesGes.setDgesComment(diagnosesGesComment);
        newDiagnosesGes.setDiagnosesBasis(diagnosesGesBasis);
        newDiagnosesGes.setTreatment(treatment);
        newDiagnosesGes.setDgesDate(fecha);
        newDiagnosesGes.setCheckGes(checkGes);
        newDiagnosesGes.setDiagId(selectedDiagnoses);

        System.out.println("Hola hasta aca");
        //diagnosesGesFacade.create(newDiagnosesGes);

    }

    public String getProblemAuge() {
        return problemAuge;
    }

    public void setProblemAuge(String problemAuge) {
        this.problemAuge = problemAuge;
    }

    public String getSubProblemAuge() {
        return subProblemAuge;
    }

    public void setSubProblemAuge(String subProblemAuge) {
        this.subProblemAuge = subProblemAuge;
    }

    public String getDiagnosesGesComment() {
        return diagnosesGesComment;
    }

    public void setDiagnosesGesComment(String diagnosesGesComment) {
        this.diagnosesGesComment = diagnosesGesComment;
    }

    public String getDiagnosesGesBasis() {
        return diagnosesGesBasis;
    }

    public void setDiagnosesGesBasis(String diagnosesGesBasis) {
        this.diagnosesGesBasis = diagnosesGesBasis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isCheckGes() {
        return checkGes;
    }

    public void setCheckGes(boolean checkGes) {
        this.checkGes = checkGes;
    }

    public Diagnoses getSelectedDiagnoses() {
        return selectedDiagnoses;
    }

    public void setSelectedDiagnoses(Diagnoses selectedDiagnoses) {
        this.selectedDiagnoses = selectedDiagnoses;
    }

    public String getRutPatient() {
        return rutPatient;
    }

    public void setRutPatient(String rutPatient) {
        this.rutPatient = rutPatient;
    }

    public List<ClinicalRecords> getGestListCR() {
        return gestListCR;
    }

    public void setGestListCR(List<ClinicalRecords> gestListCR) {
        this.gestListCR = gestListCR;
    }

    public List<Patients> getGesListPA() {
        return gesListPA;
    }

    public void setGesListPA(List<Patients> gesListPA) {
        this.gesListPA = gesListPA;
    }

    public List<Persons> getGesListPER() {
        return gesListPER;
    }

    public void setGesListPER(List<Persons> gesListPER) {
        this.gesListPER = gesListPER;
    }

    public List<Diagnoses> getGesListDGES() {
        return gesListDGES;
    }

    public void setGesListDGES(List<Diagnoses> gesListDGES) {
        this.gesListDGES = gesListDGES;
    }

}
