/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author Damian Mamla
 */
public class UserModel extends AbstractModel<User> {

    public UserModel() {
        super(User.class);
    }

    public String genrateMD5(String password) {
        MessageDigest md;
        StringBuilder sb = new StringBuilder();
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sb.toString();
    }

    public List<User> findId_advisors() {
        List<User> users = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String sql = "SELECT * FROM User WHERE status = 4";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(User.class);
            List results = query.list();
            for (Object l : results) {
                users.add((User) l);
            }
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return users;
    }
}
