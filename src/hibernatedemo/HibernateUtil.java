/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatedemo;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Norwin
 */
public class HibernateUtil {

    public static SessionFactory sessionfactory;

    static {
        try {
            sessionfactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (HibernateException he) {
            System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
            throw new ExceptionInInitializerError(he);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionfactory;
    }
}
