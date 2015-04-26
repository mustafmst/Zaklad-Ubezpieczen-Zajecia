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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Damian Mamla
 */
@Entity
@Table(name = "service")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Service.findAll", query = "SELECT s FROM Service s"),
    @NamedQuery(name = "Service.findByServiceId", query = "SELECT s FROM Service s WHERE s.serviceId = :serviceId"),
    @NamedQuery(name = "Service.findByServiceCost", query = "SELECT s FROM Service s WHERE s.serviceCost = :serviceCost"),
    @NamedQuery(name = "Service.findByInsuranceCost", query = "SELECT s FROM Service s WHERE s.insuranceCost = :insuranceCost"),
    @NamedQuery(name = "Service.findByDescription", query = "SELECT s FROM Service s WHERE s.description = :description"),
    @NamedQuery(name = "Service.findByDataOfAddService", query = "SELECT s FROM Service s WHERE s.dataOfAddService = :dataOfAddService")})
public class Service implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "serviceId")
    private Integer serviceId;
    @Basic(optional = false)
    @Column(name = "serviceCost")
    private int serviceCost;
    @Basic(optional = false)
    @Column(name = "insuranceCost")
    private int insuranceCost;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "dataOfAddService")
    @Temporal(TemporalType.DATE)
    private Date dataOfAddService;
    @JoinColumn(name = "pesel_fk", referencedColumnName = "pesel")
    @ManyToOne(optional = false)
    private Customer peselFk;
    @JoinColumn(name = "user_fk", referencedColumnName = "userId")
    @ManyToOne(optional = false)
    private User userFk;

    public Service() {
    }

    public Service(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Service(Integer serviceId, int serviceCost, int insuranceCost, String description, Date dataOfAddService) {
        this.serviceId = serviceId;
        this.serviceCost = serviceCost;
        this.insuranceCost = insuranceCost;
        this.description = description;
        this.dataOfAddService = dataOfAddService;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public int getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(int serviceCost) {
        this.serviceCost = serviceCost;
    }

    public int getInsuranceCost() {
        return insuranceCost;
    }

    public void setInsuranceCost(int insuranceCost) {
        this.insuranceCost = insuranceCost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDataOfAddService() {
        return dataOfAddService;
    }

    public void setDataOfAddService(Date dataOfAddService) {
        this.dataOfAddService = dataOfAddService;
    }

    public Customer getPeselFk() {
        return peselFk;
    }

    public void setPeselFk(Customer peselFk) {
        this.peselFk = peselFk;
    }

    public User getUserFk() {
        return userFk;
    }

    public void setUserFk(User userFk) {
        this.userFk = userFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serviceId != null ? serviceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Service)) {
            return false;
        }
        Service other = (Service) object;
        if ((this.serviceId == null && other.serviceId != null) || (this.serviceId != null && !this.serviceId.equals(other.serviceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Service[ serviceId=" + serviceId + " ]";
    }
    
}
