/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Joel
 */
@Entity
@Table(name = "diseases")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diseases.findAll", query = "SELECT d FROM Diseases d"),
    @NamedQuery(name = "Diseases.findByDisId", query = "SELECT d FROM Diseases d WHERE d.disId = :disId"),
    @NamedQuery(name = "Diseases.findByDisName", query = "SELECT d FROM Diseases d WHERE d.disName = :disName"),
    @NamedQuery(name = "Diseases.findByDisGes", query = "SELECT d FROM Diseases d WHERE d.disGes = :disGes")})
public class Diseases implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dis_id")
    private Integer disId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "dis_name")
    private String disName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dis_ges")
    private boolean disGes;
    @OneToMany(mappedBy = "disId")
    private Collection<Diagnoses> diagnosesCollection;

    public Diseases() {
    }

    public Diseases(Integer disId) {
        this.disId = disId;
    }

    public Diseases(Integer disId, String disName, boolean disGes) {
        this.disId = disId;
        this.disName = disName;
        this.disGes = disGes;
    }

    public Integer getDisId() {
        return disId;
    }

    public void setDisId(Integer disId) {
        this.disId = disId;
    }

    public String getDisName() {
        return disName;
    }

    public void setDisName(String disName) {
        this.disName = disName;
    }

    public boolean getDisGes() {
        return disGes;
    }

    public void setDisGes(boolean disGes) {
        this.disGes = disGes;
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
        hash += (disId != null ? disId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diseases)) {
            return false;
        }
        Diseases other = (Diseases) object;
        if ((this.disId == null && other.disId != null) || (this.disId != null && !this.disId.equals(other.disId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Diseases[ disId=" + disId + " ]";
    }
    
}
