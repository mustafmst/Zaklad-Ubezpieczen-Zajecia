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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Damian Mamla
 */
@Entity
@Table(name = "history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "History.findAll", query = "SELECT h FROM History h"),
    @NamedQuery(name = "History.findByHisId", query = "SELECT h FROM History h WHERE h.hisId = :hisId"),
    @NamedQuery(name = "History.findByUserId", query = "SELECT h FROM History h WHERE h.userId = :userId"),
    @NamedQuery(name = "History.findByDateOfChange", query = "SELECT h FROM History h WHERE h.dateOfChange = :dateOfChange"),
    @NamedQuery(name = "History.findByWhatChange", query = "SELECT h FROM History h WHERE h.whatChange = :whatChange")})
public class History implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "hisId")
    private Integer hisId;
    @Basic(optional = false)
    @Column(name = "userId")
    private int userId;
    @Basic(optional = false)
    @Column(name = "dateOfChange")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfChange;
    @Basic(optional = false)
    @Column(name = "whatChange")
    private String whatChange;

    public History() {
    }

    public History(Integer hisId) {
        this.hisId = hisId;
    }

    public History(Integer hisId, int userId, Date dateOfChange, String whatChange) {
        this.hisId = hisId;
        this.userId = userId;
        this.dateOfChange = dateOfChange;
        this.whatChange = whatChange;
    }

    public Integer getHisId() {
        return hisId;
    }

    public void setHisId(Integer hisId) {
        this.hisId = hisId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDateOfChange() {
        return dateOfChange;
    }

    public void setDateOfChange(Date dateOfChange) {
        this.dateOfChange = dateOfChange;
    }

    public String getWhatChange() {
        return whatChange;
    }

    public void setWhatChange(String whatChange) {
        this.whatChange = whatChange;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hisId != null ? hisId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof History)) {
            return false;
        }
        History other = (History) object;
        if ((this.hisId == null && other.hisId != null) || (this.hisId != null && !this.hisId.equals(other.hisId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.History[ hisId=" + hisId + " ]";
    }
    
}
