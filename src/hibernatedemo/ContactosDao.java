/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatedemo;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Norwin
 */
public class ContactosDao {

    private Session session;
    private Transaction tx;

    private void iniciaOperacion() throws HibernateException {
        session = HibernateUtil.sessionfactory.openSession();
        tx = session.beginTransaction();
    }

    private void manejarException(HibernateException ex) {
        tx.rollback();
        throw new HibernateException("Ocurrio Un Error");
    }

    public String guardaContacto(Contacto contacto) throws HibernateException {
        String rsp;

        try {
            iniciaOperacion();
            session.save(contacto);
            tx.commit();
            rsp = "Guardado Con Exito";
        } catch (HibernateException he) {
            manejarException(he);
            rsp = "ERROR!!";
            throw he;
        } finally {
            session.close();
        }

        return rsp;
    }

    public String actualizaContacto(Contacto contacto) throws HibernateException {
        String rsp;
        try {
            iniciaOperacion();
            session.update(contacto);
            tx.commit();
            rsp = "Modificado Con Exito";
        } catch (HibernateException he) {
            manejarException(he);
            rsp = "ERROR!!";
            throw he;
        } finally {
            session.close();
        }
        return rsp;
    }

    public String eliminaContacto(Contacto contacto) throws HibernateException {
        String rsp;
        try {
            iniciaOperacion();
            session.delete(contacto);
            tx.commit();
            rsp = "Eliminado Con Exito";
        } catch (HibernateException he) {
            manejarException(he);
            rsp = "ERROR!!";
            throw he;
        } finally {
            session.close();
        }
        return rsp;
    }

    public Contacto obtenContacto(long idContacto) throws HibernateException {
        Contacto contacto = null;
        try {
            iniciaOperacion();
            contacto = (Contacto) session.get(Contacto.class, idContacto);
        } finally {
            session.close();
        }
        return contacto;
    }

    public List<Contacto> obtenListaContactos() throws HibernateException {
        List<Contacto> listaContactos = null;

        try {
            iniciaOperacion();
            listaContactos = session.createQuery("from Contacto").list();
        } finally {
            session.close();
        }

        return listaContactos;
    }

}
