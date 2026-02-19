package com.waste.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.waste.bean.Citizen;
import com.waste.util.HibernateUtil;

public class CitizenDAO {

    public boolean insertCitizen(Citizen citizen) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(citizen);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public Citizen findCitizen(String citizenID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Citizen.class, citizenID);
        }
    }

    public List<Citizen> viewAllCitizens() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Citizen", Citizen.class).list();
        }
    }

    public boolean updateCitizenStatus(String citizenID, String status) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Citizen c = session.get(Citizen.class, citizenID);
            if (c != null) {
                c.setStatus(status);
                session.merge(c);
                tx.commit();
                return true;
            }
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteCitizen(String citizenID) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Citizen c = session.get(Citizen.class, citizenID);
            if (c != null) {
                session.remove(c);
                tx.commit();
                return true;
            }
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return false;
    }
}
