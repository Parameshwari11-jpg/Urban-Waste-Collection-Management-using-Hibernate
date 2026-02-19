package com.waste.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.waste.bean.WasteServiceRow;
import com.waste.util.HibernateUtil;

public class WasteServiceDAO {

    public boolean insertServiceRow(WasteServiceRow row) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(row);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public WasteServiceRow findServiceRow(int serviceRowID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(WasteServiceRow.class, serviceRowID);
        }
    }

    public List<WasteServiceRow> findComplaintsByCitizen(String citizenID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "from WasteServiceRow where serviceType='COMPLAINT' and citizenId=:cid",
                    WasteServiceRow.class)
                    .setParameter("cid", citizenID)
                    .list();
        }
    }

    public List<WasteServiceRow> findOpenComplaintsByCitizen(String citizenID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "from WasteServiceRow where citizenId=:cid and complaintStatus in ('OPEN','IN_PROGRESS')",
                    WasteServiceRow.class)
                    .setParameter("cid", citizenID)
                    .list();
        }
    }

    public boolean updateComplainStatusAndClosure(int serviceRowID,
                                                  String newStatus,
                                                  String closureRemarks) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            WasteServiceRow row = session.get(WasteServiceRow.class, serviceRowID);
            if (row != null) {
                row.setComplaintStatus(newStatus);
                row.setClosureRemarks(closureRemarks);
                session.update(row);
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
