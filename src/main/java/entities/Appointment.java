/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author DR
 */

@Entity
@Table(name = "appointment")

public class Appointment implements Serializable{
    
    @Column(name = "id_advisor")
    private int id_advisor;
    
    @Column(name = "hours")
    //@Temporal(TemporalType.TIME)
    private Time hours;
    
    @Column(name = "dateofAddAppointment")
    @Temporal(TemporalType.DATE)
    private Date dateofAddAppointment;
    
    @Id
    @Column(name = "pesel")
    private String pesel;
    
    public Appointment(){
    }
    
    public Appointment(String pesel,int id_advisor,Date dateofAddAppointment,Time hours){
        this.pesel = pesel;
        this.id_advisor = id_advisor;
        this.dateofAddAppointment = dateofAddAppointment;
        this.hours = hours;
    }
    
    public void setPesel(String pesel){
        this.pesel = pesel;
    }
    public String getPesel(){
        return this.pesel;
    }
    
    public void setId_advisor(int id_advisor){
        this.id_advisor = id_advisor;
    }
    public int getId_advisor(){
        return this.id_advisor;
    }
    
    public void setHours(Time hours){
        this.hours = hours;
    }
    public Time getHours(){
        return this.hours;
    }
    
    public void setDateofAddAppointment(Date dateofAddAppointment){
        this.dateofAddAppointment = dateofAddAppointment;
    }
    public Date getDateofAddAppointment(){
        return this.dateofAddAppointment;
    }
}
