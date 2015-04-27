/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.*;
import java.util.*;
import org.hibernate.*;

/**
 *
 * @author Damian Mamla
 * @param <T>
 */
@SuppressWarnings("unchecked")
public abstract class AbstractModel<T> {

    private Class<T> entityClass;
    protected final SessionFactory sessionFactory = HibernateUtil
            .getSessionFactory();

    public AbstractModel(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public AbstractModel() {
    }

    public List<T> findAll() {
        try {
            if (!sessionFactory.getCurrentSession().getTransaction().isActive()) {
                sessionFactory.getCurrentSession().getTransaction().begin();
            }
            return sessionFactory.getCurrentSession()
                    .createQuery("from " + entityClass.getSimpleName()).list();
        } catch (RuntimeException re) {
            return null;
        }
    }

    public void update(T instance) {
        try {
            if (!sessionFactory.getCurrentSession().getTransaction().isActive()) {
                sessionFactory.getCurrentSession().getTransaction().begin();
            }
            sessionFactory.getCurrentSession().merge(instance);
            sessionFactory.getCurrentSession().getTransaction().commit();
        } catch (RuntimeException re) {
            sessionFactory.getCurrentSession().getTransaction().rollback();
            throw re;
        }
    }

    public void delete(T instance) {
        try {
            if (!sessionFactory.getCurrentSession().getTransaction().isActive()) {
                sessionFactory.getCurrentSession().getTransaction().begin();
            }
            sessionFactory.getCurrentSession().delete(instance);
            sessionFactory.getCurrentSession().getTransaction().commit();
        } catch (RuntimeException re) {
            sessionFactory.getCurrentSession().getTransaction().rollback();
            throw re;
        }
    }

    public void create(T instance) {
        try {
            if (!sessionFactory.getCurrentSession().getTransaction().isActive()) {
                sessionFactory.getCurrentSession().getTransaction().begin();
            }
            sessionFactory.getCurrentSession().persist(instance);
            sessionFactory.getCurrentSession().getTransaction().commit();
        } catch (RuntimeException re) {
            sessionFactory.getCurrentSession().getTransaction().rollback();
            throw re;
        }
    }

    public T find(Object primarykey) {
        try {
            if (!sessionFactory.getCurrentSession().getTransaction().isActive()) {
                sessionFactory.getCurrentSession().getTransaction().begin();
            }
            return (T) sessionFactory.getCurrentSession().get(entityClass,
                    (Serializable) primarykey);
        } catch (RuntimeException re) {
            return null;
        }
    }
}
