package com.Wanderlust.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;

public class HibernateUtil {
    static Session getSession() {
        Session session = null;
        try {
        	
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");

            SessionFactory sessionFactory = cfg.buildSessionFactory();

            session = sessionFactory.openSession();
            
        } catch (HibernateException e) {
            System.err.println("Failed to create sessionFactory object. " + e);
        }
        
        catch (Exception e) {
            System.err.println("An unexpected error occurred while creating the session. " + e);
        }
        
        return session;
    }
}
