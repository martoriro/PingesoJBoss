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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Joel
 */
@Entity
@Table(name = "clinical_records")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClinicalRecords.findAll", query = "SELECT c FROM ClinicalRecords c"),
    @NamedQuery(name = "ClinicalRecords.findByCrecId", query = "SELECT c FROM ClinicalRecords c WHERE c.crecId = :crecId"),
    @NamedQuery(name = "ClinicalRecords.findByCrecDate", query = "SELECT c FROM ClinicalRecords c WHERE c.crecDate = :crecDate"),
    @NamedQuery(name = "ClinicalRecords.findByPersonId", query = "SELECT c FROM ClinicalRecords c WHERE c.personId = :personId")})
public class ClinicalRecords implements Serializable {
    @OneToMany(mappedBy = "crecId")
    private Collection<MedicalHistories> medicalHistoriesCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "crec_id")
    private Integer crecId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "crec_date")
    @Temporal(TemporalType.DATE)
    private Date crecDate;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    @ManyToOne(optional = false)
    private Patients personId;
    @OneToMany(mappedBy = "crecId")
    private Collection<Diagnoses> diagnosesCollection;

    public ClinicalRecords() {
    }

    public ClinicalRecords(Integer crecId) {
        this.crecId = crecId;
    }

    public ClinicalRecords(Integer crecId, Date crecDate) {
        this.crecId = crecId;
        this.crecDate = crecDate;
    }

    public Integer getCrecId() {
        return crecId;
    }

    public void setCrecId(Integer crecId) {
        this.crecId = crecId;
    }

    public Date getCrecDate() {
        return crecDate;
    }

    public void setCrecDate(Date crecDate) {
        this.crecDate = crecDate;
    }

    public Patients getPersonId() {
        return personId;
    }

    public void setPersonId(Patients personId) {
        this.personId = personId;
    }

    @XmlTransient
    public Collection<Diagnoses> getDiagnosesCollection() {
        return diagnosesCollection;
    }

    public void setDiagnosesCollection(Collection<Diagnoses> diagnosesCollection) {
        this.diagnosesCollection = diagnosesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (crecId != null ? crecId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClinicalRecords)) {
            return false;
        }
        ClinicalRecords other = (ClinicalRecords) object;
        if ((this.crecId == null && other.crecId != null) || (this.crecId != null && !this.crecId.equals(other.crecId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ClinicalRecords[ crecId=" + crecId + " ]";
    }

    @XmlTransient
    public Collection<MedicalHistories> getMedicalHistoriesCollection() {
        return medicalHistoriesCollection;
    }

    public void setMedicalHistoriesCollection(Collection<MedicalHistories> medicalHistoriesCollection) {
        this.medicalHistoriesCollection = medicalHistoriesCollection;
    }

}
