/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 *
 * @author Damian Mamla
 */
@Entity
@Table(name = "customer")

public class Customer implements Serializable {
    
    @Column(name = "firstName")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "lastName")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "phone")
    private int phone;
    @Column(name = "adress")
    private String adress;
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Id
    @Column(name = "pesel")
    private String pesel;

    public Customer() {
    }

    public Customer(String pesel) {
        this.pesel = pesel;
    }

    public Customer( String firstName, String lastName, int phone, String pesel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.pesel = pesel;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    
}
