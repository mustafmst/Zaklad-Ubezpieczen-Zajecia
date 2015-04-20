/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.*;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author Damian Mamla
 */
public class CustomerModel extends AbstractModel<Customer> {

    public CustomerModel() {
        super(Customer.class);
    }

    public Customer findCustomer(Customer customer) {
        Customer cust = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String sql = "SELECT * FROM Customer WHERE firstName = :firstName"
                    + " and lastName = :lastName"
                    + " and adress = :adress"
                    + " and pesel = :pesel"
                    + " and phone = :phone"
                    + " and email = :email";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Customer.class);
            query.setParameter("firstName", customer.getFirstName());
            query.setParameter("lastName", customer.getLastName());
            query.setParameter("adress", customer.getAdress());
            query.setParameter("pesel", customer.getPesel());
            query.setParameter("phone", customer.getPhone());
            query.setParameter("email", customer.getEmail());
            List results = query.list();
            for (Object l : results) {
                cust = (Customer) l;
            }
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return cust;
    }
}
