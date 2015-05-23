/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
     
    @Id
    @Column(name = "appointmentId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appointmentId;
    
    
    @Column(name = "id_advisor")
    private int id_advisor;
    
    @Column(name = "hours")
    //@Temporal(TemporalType.TIME)
    private Time hours;
    
    @Column(name = "dateofAddAppointment")
    @Temporal(TemporalType.DATE)
    private Date dateofAddAppointment;
   
    @Column(name = "pesel")
    private String pesel;
    
    public Appointment(){
    }
    
    public Appointment(Integer appointmentId, String pesel,int id_advisor,Date dateofAddAppointment,Time hours){
        this.appointmentId = appointmentId;
        this.pesel = pesel;
        this.id_advisor = id_advisor;
        this.dateofAddAppointment = dateofAddAppointment;
        this.hours = hours;
    }
    
    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
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
