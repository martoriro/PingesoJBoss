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
@Table(name = "diagnose_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiagnoseStatus.findAll", query = "SELECT d FROM DiagnoseStatus d"),
    @NamedQuery(name = "DiagnoseStatus.findByDstatId", query = "SELECT d FROM DiagnoseStatus d WHERE d.dstatId = :dstatId"),
    @NamedQuery(name = "DiagnoseStatus.findByDstatName", query = "SELECT d FROM DiagnoseStatus d WHERE d.dstatName = :dstatName")})
public class DiagnoseStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dstat_id")
    private Integer dstatId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "dstat_name")
    private String dstatName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dstatId")
    private Collection<Diagnoses> diagnosesCollection;

    public DiagnoseStatus() {
    }

    public DiagnoseStatus(Integer dstatId) {
        this.dstatId = dstatId;
    }

    public DiagnoseStatus(Integer dstatId, String dstatName) {
        this.dstatId = dstatId;
        this.dstatName = dstatName;
    }

    public Integer getDstatId() {
        return dstatId;
    }

    public void setDstatId(Integer dstatId) {
        this.dstatId = dstatId;
    }

    public String getDstatName() {
        return dstatName;
    }

    public void setDstatName(String dstatName) {
        this.dstatName = dstatName;
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
        hash += (dstatId != null ? dstatId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiagnoseStatus)) {
            return false;
        }
        DiagnoseStatus other = (DiagnoseStatus) object;
        if ((this.dstatId == null && other.dstatId != null) || (this.dstatId != null && !this.dstatId.equals(other.dstatId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DiagnoseStatus[ dstatId=" + dstatId + " ]";
    }
    
}
