/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Joel
 */
@Entity
@Table(name = "persons")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persons.findAll", query = "SELECT p FROM Persons p"),
    @NamedQuery(name = "Persons.findByPersonId", query = "SELECT p FROM Persons p WHERE p.personId = :personId"),
    @NamedQuery(name = "Persons.findByRut", query = "SELECT p FROM Persons p WHERE p.rut = :rut"),
    @NamedQuery(name = "Persons.findByPerNames", query = "SELECT p FROM Persons p WHERE p.perNames = :perNames"),
    @NamedQuery(name = "Persons.findByPerFathername", query = "SELECT p FROM Persons p WHERE p.perFathername = :perFathername"),
    @NamedQuery(name = "Persons.findByPerMothername", query = "SELECT p FROM Persons p WHERE p.perMothername = :perMothername"),
    @NamedQuery(name = "Persons.findByPerEmail", query = "SELECT p FROM Persons p WHERE p.perEmail = :perEmail"),
    @NamedQuery(name = "Persons.findByPerPhone", query = "SELECT p FROM Persons p WHERE p.perPhone = :perPhone"),
    @NamedQuery(name = "Persons.findByPerMobile", query = "SELECT p FROM Persons p WHERE p.perMobile = :perMobile"),
    @NamedQuery(name = "Persons.findByPerContactPhone", query = "SELECT p FROM Persons p WHERE p.perContactPhone = :perContactPhone"),
    @NamedQuery(name = "Persons.findByPerAddress", query = "SELECT p FROM Persons p WHERE p.perAddress = :perAddress"),
    @NamedQuery(name = "Persons.findByPerDptNumber", query = "SELECT p FROM Persons p WHERE p.perDptNumber = :perDptNumber"),
    @NamedQuery(name = "Persons.findByPerOcupation", query = "SELECT p FROM Persons p WHERE p.perOcupation = :perOcupation"),
    @NamedQuery(name = "Persons.findByPerActivity", query = "SELECT p FROM Persons p WHERE p.perActivity = :perActivity"),
    @NamedQuery(name = "Persons.findByPerBirthdate", query = "SELECT p FROM Persons p WHERE p.perBirthdate = :perBirthdate"),
    @NamedQuery(name = "Persons.findByPerNationality", query = "SELECT p FROM Persons p WHERE p.perNationality = :perNationality"),
    @NamedQuery(name = "Persons.findByPerPassport", query = "SELECT p FROM Persons p WHERE p.perPassport = :perPassport")})
public class Persons implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "person_id")
    private Integer personId;
    @Size(max = 10)
    @Column(name = "rut")
    private String rut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "per_names")
    private String perNames;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "per_fathername")
    private String perFathername;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "per_mothername")
    private String perMothername;
    @Size(max = 256)
    @Column(name = "per_email")
    private String perEmail;
    @Column(name = "per_phone")
    private Integer perPhone;
    @Column(name = "per_mobile")
    private Integer perMobile;
    @Column(name = "per_contact_phone")
    private Integer perContactPhone;
    @Column(name = "per_address")
    private Integer perAddress;
    @Column(name = "per_dpt_number")
    private Integer perDptNumber;
    @Column(name = "per_ocupation")
    private Integer perOcupation;
    @Column(name = "per_activity")
    private Integer perActivity;
    @Column(name = "per_birthdate")
    @Temporal(TemporalType.DATE)
    private Date perBirthdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "per_nationality")
    private String perNationality;
    @Size(max = 20)
    @Column(name = "per_passport")
    private String perPassport;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "persons")
    private Patients patients;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "persons")
    private Professionals professionals;

    public Persons() {
    }

    public Persons(Integer personId) {
        this.personId = personId;
    }

    public Persons(Integer personId, String perNames, String perFathername, String perMothername, String perNationality) {
        this.personId = personId;
        this.perNames = perNames;
        this.perFathername = perFathername;
        this.perMothername = perMothername;
        this.perNationality = perNationality;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getPerNames() {
        return perNames;
    }

    public void setPerNames(String perNames) {
        this.perNames = perNames;
    }

    public String getPerFathername() {
        return perFathername;
    }

    public void setPerFathername(String perFathername) {
        this.perFathername = perFathername;
    }

    public String getPerMothername() {
        return perMothername;
    }

    public void setPerMothername(String perMothername) {
        this.perMothername = perMothername;
    }

    public String getPerEmail() {
        return perEmail;
    }

    public void setPerEmail(String perEmail) {
        this.perEmail = perEmail;
    }

    public Integer getPerPhone() {
        return perPhone;
    }

    public void setPerPhone(Integer perPhone) {
        this.perPhone = perPhone;
    }

    public Integer getPerMobile() {
        return perMobile;
    }

    public void setPerMobile(Integer perMobile) {
        this.perMobile = perMobile;
    }

    public Integer getPerContactPhone() {
        return perContactPhone;
    }

    public void setPerContactPhone(Integer perContactPhone) {
        this.perContactPhone = perContactPhone;
    }

    public Integer getPerAddress() {
        return perAddress;
    }

    public void setPerAddress(Integer perAddress) {
        this.perAddress = perAddress;
    }

    public Integer getPerDptNumber() {
        return perDptNumber;
    }

    public void setPerDptNumber(Integer perDptNumber) {
        this.perDptNumber = perDptNumber;
    }

    public Integer getPerOcupation() {
        return perOcupation;
    }

    public void setPerOcupation(Integer perOcupation) {
        this.perOcupation = perOcupation;
    }

    public Integer getPerActivity() {
        return perActivity;
    }

    public void setPerActivity(Integer perActivity) {
        this.perActivity = perActivity;
    }

    public Date getPerBirthdate() {
        return perBirthdate;
    }

    public void setPerBirthdate(Date perBirthdate) {
        this.perBirthdate = perBirthdate;
    }

    public String getPerNationality() {
        return perNationality;
    }

    public void setPerNationality(String perNationality) {
        this.perNationality = perNationality;
    }

    public String getPerPassport() {
        return perPassport;
    }

    public void setPerPassport(String perPassport) {
        this.perPassport = perPassport;
    }

    public Patients getPatients() {
        return patients;
    }

    public void setPatients(Patients patients) {
        this.patients = patients;
    }

    public Professionals getProfessionals() {
        return professionals;
    }

    public void setProfessionals(Professionals professionals) {
        this.professionals = professionals;
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
        if (!(object instanceof Persons)) {
            return false;
        }
        Persons other = (Persons) object;
        if ((this.personId == null && other.personId != null) || (this.personId != null && !this.personId.equals(other.personId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Persons[ personId=" + personId + " ]";
    }
    
}
