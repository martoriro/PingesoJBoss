/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBean.newDiagnostic;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Martín
 */
@ManagedBean
@RequestScoped
public class NewIPD {
    
    private boolean confirmIPD;
    private String augeProblem;
    private String augeSubproblem;
    private String diagnosticIPD;
    private String diagnosticfIPD;
    private String treatmentIPD;
    private Date limitDateIPD;
    
    public NewIPD() {
    }

    public boolean isConfirmIPD() {
        return confirmIPD;
    }

    public void setConfirmIPD(boolean confirmIPD) {
        this.confirmIPD = confirmIPD;
    }

    public String getAugeProblem() {
        return augeProblem;
    }

    public void setAugeProblem(String augeProblem) {
        this.augeProblem = augeProblem;
    }

    public String getAugeSubproblem() {
        return augeSubproblem;
    }

    public void setAugeSubproblem(String augeSubproblem) {
        this.augeSubproblem = augeSubproblem;
    }

    public String getDiagnosticIPD() {
        return diagnosticIPD;
    }

    public void setDiagnosticIPD(String diagnosticIPD) {
        this.diagnosticIPD = diagnosticIPD;
    }

    public String getDiagnosticfIPD() {
        return diagnosticfIPD;
    }

    public void setDiagnosticfIPD(String diagnosticfIPD) {
        this.diagnosticfIPD = diagnosticfIPD;
    }

    public String getTreatmentIPD() {
        return treatmentIPD;
    }

    public void setTreatmentIPD(String treatmentIPD) {
        this.treatmentIPD = treatmentIPD;
    }

    public Date getLimitDateIPD() {
        return limitDateIPD;
    }

    public void setLimitDateIPD(Date limitDateIPD) {
        this.limitDateIPD = limitDateIPD;
    }
    
    public void resetInput(){
        this.augeProblem = "";
        this.augeSubproblem = "";
        this.confirmIPD = false;
        this.diagnosticIPD = "";
        this.diagnosticfIPD = "";
        this.limitDateIPD = null;
        this.treatmentIPD = "";
    }
    
}
