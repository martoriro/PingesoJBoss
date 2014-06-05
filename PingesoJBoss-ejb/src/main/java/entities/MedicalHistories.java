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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Joel
 */
@Entity
@Table(name = "medical_histories")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MedicalHistories.findAll", query = "SELECT m FROM MedicalHistories m"),
    @NamedQuery(name = "MedicalHistories.findByMhysId", query = "SELECT m FROM MedicalHistories m WHERE m.mhysId = :mhysId"),
    @NamedQuery(name = "MedicalHistories.findByMhistory", query = "SELECT m FROM MedicalHistories m WHERE m.mhistory = :mhistory"),
    @NamedQuery(name = "MedicalHistories.findByMhysDtime", query = "SELECT m FROM MedicalHistories m WHERE m.mhysDtime = :mhysDtime"),
    @NamedQuery(name = "MedicalHistories.findByCrecId", query = "SELECT m FROM MedicalHistories m WHERE m.crecId = :crecId")})
public class MedicalHistories implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mhys_id")
    private Integer mhysId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "mhistory")
    private String mhistory;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mhys_dtime")
    @Temporal(TemporalType.DATE)
    private Date mhysDtime;
    @JoinColumn(name = "crec_id", referencedColumnName = "crec_id")
    @ManyToOne
    private ClinicalRecords crecId;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    @ManyToOne(optional = false)
    private Professionals personId;

    public MedicalHistories() {
    }

    public MedicalHistories(Integer mhysId) {
        this.mhysId = mhysId;
    }

    public MedicalHistories(Integer mhysId, String mhistory, Date mhysDtime) {
        this.mhysId = mhysId;
        this.mhistory = mhistory;
        this.mhysDtime = mhysDtime;
    }

    public Integer getMhysId() {
        return mhysId;
    }

    public void setMhysId(Integer mhysId) {
        this.mhysId = mhysId;
    }

    public String getMhistory() {
        return mhistory;
    }

    public void setMhistory(String mhistory) {
        this.mhistory = mhistory;
    }

    public Date getMhysDtime() {
        return mhysDtime;
    }

    public void setMhysDtime(Date mhysDtime) {
        this.mhysDtime = mhysDtime;
    }

    public ClinicalRecords getCrecId() {
        return crecId;
    }

    public void setCrecId(ClinicalRecords crecId) {
        this.crecId = crecId;
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
        hash += (mhysId != null ? mhysId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedicalHistories)) {
            return false;
        }
        MedicalHistories other = (MedicalHistories) object;
        if ((this.mhysId == null && other.mhysId != null) || (this.mhysId != null && !this.mhysId.equals(other.mhysId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MedicalHistories[ mhysId=" + mhysId + " ]";
    }

}
