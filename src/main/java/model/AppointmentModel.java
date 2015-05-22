/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author DR
 */
public class AppointmentModel extends AbstractModel<Appointment> {
    
    public AppointmentModel() {
        super(Appointment.class);
    }
    
    public List<Appointment> findAppointment(Date date) {
        List<Appointment> app = new ArrayList<Appointment>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String sql = "SELECT * FROM Appointment WHERE dateofAddAppointment = '"+
                    date.getYear()+"-"+date.getMonth()+"-"+date.getDate()+"'";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Appointment.class);
            List results = query.list();
            for (Object l : results) {
                app.add((Appointment)l);
            }
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return app;
    }
    
    public Appointment findAppointmentPesel(Date date, String pesel) {
        Appointment app = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String sql = "SELECT * FROM Appointment WHERE dateofAddAppointment = '"+
                    (1900+date.getYear())+"-"+(1+date.getMonth())+"-"+date.getDate()+"'"+
                    " and pesel = '"+pesel+"'";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Appointment.class);
            List results = query.list();
            for (Object l : results) {
                app=(Appointment)l;
            }
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return app;
    }
    
    
    
}
