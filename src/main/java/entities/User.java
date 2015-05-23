/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Damian Mamla
 */
@Entity
@Table(name="user")

@SuppressWarnings("ValidPrimaryTableName")
public class User implements java.io.Serializable {
    @Basic(optional = false)
    @Lob
    @Column(name = "password")
    private String password;

   
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userId")
@Id
    private Integer userId;
    @Basic(optional = false)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @Column(name = "stanowisko")
    private String stanowisko;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @Basic(optional = false)
    @Column(name = "imie")
    private String imie;
    @Basic(optional = false)
    @Column(name = "nazwisko")
    private String nazwisko;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userFk")
    private Collection<Service> serviceCollection;
   
 
    public User() {}
    
    public User(Integer userId) {
        this.userId = userId;
    }

    public User(Integer userId, String login, String password, String stanowisko, int status, String imie, String nazwisko) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.stanowisko = stanowisko;
        this.status = status;
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

   @XmlTransient
    public Collection<Service> getServiceCollection() {
        return serviceCollection;
    }

    public void setServiceCollection(Collection<Service> serviceCollection) {
        this.serviceCollection = serviceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        return !((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId)));
    }

    @Override
    public String toString() {
        return "entities.User[ userId=" + userId + " ]";
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
