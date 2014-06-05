/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Joel
 */
@Entity
@Table(name = "diagnoses_ges")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiagnosesGes.findAll", query = "SELECT d FROM DiagnosesGes d"),
    @NamedQuery(name = "DiagnosesGes.findByDgesId", query = "SELECT d FROM DiagnosesGes d WHERE d.dgesId = :dgesId"),
    @NamedQuery(name = "DiagnosesGes.findByProblemAuge", query = "SELECT d FROM DiagnosesGes d WHERE d.problemAuge = :problemAuge"),
    @NamedQuery(name = "DiagnosesGes.findBySubproblemAuge", query = "SELECT d FROM DiagnosesGes d WHERE d.subproblemAuge = :subproblemAuge"),
    @NamedQuery(name = "DiagnosesGes.findByDgesComment", query = "SELECT d FROM DiagnosesGes d WHERE d.dgesComment = :dgesComment"),
    @NamedQuery(name = "DiagnosesGes.findByDiagnosesBasis", query = "SELECT d FROM DiagnosesGes d WHERE d.diagnosesBasis = :diagnosesBasis"),
    @NamedQuery(name = "DiagnosesGes.findByTreatment", query = "SELECT d FROM DiagnosesGes d WHERE d.treatment = :treatment"),
    @NamedQuery(name = "DiagnosesGes.findByDgesDate", query = "SELECT d FROM DiagnosesGes d WHERE d.dgesDate = :dgesDate"),
    @NamedQuery(name = "DiagnosesGes.findByCheckGes", query = "SELECT d FROM DiagnosesGes d WHERE d.checkGes = :checkGes")})
public class DiagnosesGes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dges_id")
    private Integer dgesId;
    @Size(max = 2147483647)
    @Column(name = "problem_auge")
    private String problemAuge;
    @Size(max = 2147483647)
    @Column(name = "subproblem_auge")
    private String subproblemAuge;
    @Size(max = 2147483647)
    @Column(name = "dges_comment")
    private String dgesComment;
    @Size(max = 2147483647)
    @Column(name = "diagnoses_basis")
    private String diagnosesBasis;
    @Size(max = 2147483647)
    @Column(name = "treatment")
    private String treatment;
    @Column(name = "dges_date")
    @Temporal(TemporalType.DATE)
    private Date dgesDate;
    @Column(name = "check_ges")
    private Boolean checkGes;
    @JoinColumn(name = "diag_id", referencedColumnName = "diag_id")
    @ManyToOne
    private Diagnoses diagId;

    public DiagnosesGes() {
    }

    public DiagnosesGes(Integer dgesId) {
        this.dgesId = dgesId;
    }

    public Integer getDgesId() {
        return dgesId;
    }

    public void setDgesId(Integer dgesId) {
        this.dgesId = dgesId;
    }

    public String getProblemAuge() {
        return problemAuge;
    }

    public void setProblemAuge(String problemAuge) {
        this.problemAuge = problemAuge;
    }

    public String getSubproblemAuge() {
        return subproblemAuge;
    }

    public void setSubproblemAuge(String subproblemAuge) {
        this.subproblemAuge = subproblemAuge;
    }

    public String getDgesComment() {
        return dgesComment;
    }

    public void setDgesComment(String dgesComment) {
        this.dgesComment = dgesComment;
    }

    public String getDiagnosesBasis() {
        return diagnosesBasis;
    }

    public void setDiagnosesBasis(String diagnosesBasis) {
        this.diagnosesBasis = diagnosesBasis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public Date getDgesDate() {
        return dgesDate;
    }

    public void setDgesDate(Date dgesDate) {
        this.dgesDate = dgesDate;
    }

    public Boolean getCheckGes() {
        return checkGes;
    }

    public void setCheckGes(Boolean checkGes) {
        this.checkGes = checkGes;
    }

    public Diagnoses getDiagId() {
        return diagId;
    }

    public void setDiagId(Diagnoses diagId) {
        this.diagId = diagId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dgesId != null ? dgesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiagnosesGes)) {
            return false;
        }
        DiagnosesGes other = (DiagnosesGes) object;
        if ((this.dgesId == null && other.dgesId != null) || (this.dgesId != null && !this.dgesId.equals(other.dgesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DiagnosesGes[ dgesId=" + dgesId + " ]";
    }
    
}
