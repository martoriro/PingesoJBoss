/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Joel
 */
@Entity
@Table(name = "professionals")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Professionals.findAll", query = "SELECT p FROM Professionals p"),
    @NamedQuery(name = "Professionals.findByPersonId", query = "SELECT p FROM Professionals p WHERE p.personId = :personId")})
public class Professionals implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
    private Collection<MedicalHistories> medicalHistoriesCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "person_id")
    private Integer personId;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Persons persons;
    @OneToMany(mappedBy = "personId")
    private Collection<Diagnoses> diagnosesCollection;

    public Professionals() {
    }

    public Professionals(Integer personId) {
        this.personId = personId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Persons getPersons() {
        return persons;
    }

    public void setPersons(Persons persons) {
        this.persons = persons;
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
        hash += (personId != null ? personId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Professionals)) {
            return false;
        }
        Professionals other = (Professionals) object;
        if ((this.personId == null && other.personId != null) || (this.personId != null && !this.personId.equals(other.personId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Professionals[ personId=" + personId + " ]";
    }

    @XmlTransient
    public Collection<MedicalHistories> getMedicalHistoriesCollection() {
        return medicalHistoriesCollection;
    }

    public void setMedicalHistoriesCollection(Collection<MedicalHistories> medicalHistoriesCollection) {
        this.medicalHistoriesCollection = medicalHistoriesCollection;
    }
    
}
