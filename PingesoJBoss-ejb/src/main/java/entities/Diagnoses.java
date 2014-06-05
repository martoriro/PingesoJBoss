/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Joel
 */
@Entity
@Table(name = "diagnoses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diagnoses.findAll", query = "SELECT d FROM Diagnoses d"),
    @NamedQuery(name = "Diagnoses.findByDiagId", query = "SELECT d FROM Diagnoses d WHERE d.diagId = :diagId"),
    @NamedQuery(name = "Diagnoses.findByDiagDate", query = "SELECT d FROM Diagnoses d WHERE d.diagDate = :diagDate"),
    @NamedQuery(name = "Diagnoses.findByDiagComment", query = "SELECT d FROM Diagnoses d WHERE d.diagComment = :diagComment"),
    @NamedQuery(name = "Diagnoses.findByEvolved", query = "SELECT d FROM Diagnoses d WHERE d.evolved = :evolved"),
    @NamedQuery(name = "Diagnoses.findByEvolvednext", query = "SELECT d FROM Diagnoses d WHERE d.evolvednext = :evolvednext"),
    @NamedQuery(name = "Diagnoses.findByCrecId", query = "SELECT d FROM Diagnoses d WHERE d.crecId = :crecId")})
public class Diagnoses implements Serializable {
    @OneToMany(mappedBy = "diagId")
    private Collection<DiagnosesGes> diagnosesGesCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "diag_id")
    private Integer diagId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "diag_date")
    @Temporal(TemporalType.DATE)
    private Date diagDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "diag_comment")
    private String diagComment;
    @Column(name = "evolved")
    private Integer evolved;
    @Column(name = "evolvednext")
    private Integer evolvednext;
    @JoinColumn(name = "crec_id", referencedColumnName = "crec_id")
    @ManyToOne
    private ClinicalRecords crecId;
    @JoinColumn(name = "dstat_id", referencedColumnName = "dstat_id")
    @ManyToOne(optional = false)
    private DiagnoseStatus dstatId;
    @JoinColumn(name = "dis_id", referencedColumnName = "dis_id")
    @ManyToOne
    private Diseases disId;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    @ManyToOne
    private Professionals personId;

    public Diagnoses() {
    }

    public Diagnoses(Integer diagId) {
        this.diagId = diagId;
    }

    public Diagnoses(Integer diagId, Date diagDate, String diagComment) {
        this.diagId = diagId;
        this.diagDate = diagDate;
        this.diagComment = diagComment;
    }

    public Integer getDiagId() {
        return diagId;
    }

    public void setDiagId(Integer diagId) {
        this.diagId = diagId;
    }

    public Date getDiagDate() {
        return diagDate;
    }

    public void setDiagDate(Date diagDate) {
        this.diagDate = diagDate;
    }

    public String getDiagComment() {
        return diagComment;
    }

    public void setDiagComment(String diagComment) {
        this.diagComment = diagComment;
    }

    public Integer getEvolved() {
        return evolved;
    }

    public void setEvolved(Integer evolved) {
        this.evolved = evolved;
    }

    public Integer getEvolvednext() {
        return evolvednext;
    }

    public void setEvolvednext(Integer evolvednext) {
        this.evolvednext = evolvednext;
    }

    public ClinicalRecords getCrecId() {
        return crecId;
    }

    public void setCrecId(ClinicalRecords crecId) {
        this.crecId = crecId;
    }

    public DiagnoseStatus getDstatId() {
        return dstatId;
    }

    public void setDstatId(DiagnoseStatus dstatId) {
        this.dstatId = dstatId;
    }

    public Diseases getDisId() {
        return disId;
    }

    public void setDisId(Diseases disId) {
        this.disId = disId;
    }

    public Professionals getPersonId() {
        return personId;
    }

    public void setPersonId(Professionals personId) {
        this.personId = personId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (diagId != null ? diagId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diagnoses)) {
            return false;
        }
        Diagnoses other = (Diagnoses) object;
        if ((this.diagId == null && other.diagId != null) || (this.diagId != null && !this.diagId.equals(other.diagId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Diagnoses[ diagId=" + diagId + " ]";
    }

    @XmlTransient
    public Collection<DiagnosesGes> getDiagnosesGesCollection() {
        return diagnosesGesCollection;
    }

    public void setDiagnosesGesCollection(Collection<DiagnosesGes> diagnosesGesCollection) {
        this.diagnosesGesCollection = diagnosesGesCollection;
    }

}
