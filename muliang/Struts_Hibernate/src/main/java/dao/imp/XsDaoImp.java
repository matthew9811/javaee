package dao.imp;

import dao.XsDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import model.Xsb;

public class XsDaoImp implements XsDao {
    public Xsb getOneXs(String xh) {
        try {
            Session session = util.HibernateSessionFactory.getSession();
            Transaction ts = session.beginTransaction();
            Query query = session.createQuery("from Xsb where xh=?");
            query.setParameter(0, xh);
            query.setMaxResults(1);
            Xsb xs = (Xsb) query.uniqueResult();
            ts.commit();
            session.clear();
            return xs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(Xsb xs) {
        try {
            Session session = util.HibernateSessionFactory.getSession();
            Transaction ts = session.beginTransaction();
            session.update(xs);
            ts.commit();
            util.HibernateSessionFactory.closeSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
