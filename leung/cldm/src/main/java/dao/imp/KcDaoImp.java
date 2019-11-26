package dao.imp;

import java.util.List;

import dao.KcDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import model.Kcb;

public class KcDaoImp implements KcDao {

    public Kcb getOneKc(String kch) {

        try {
            Session session = util.HibernateSessionFactory.getSession();
            Transaction ts = session.beginTransaction();
            Query query = session.createQuery("from Kcb where kch=?");
            query.setParameter(0, kch);
            query.setMaxResults(1);
            Kcb kc = (Kcb) query.uniqueResult();
            ts.commit();
            session.clear();
            return kc;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List getAll() {
        try {
            Session session = util.HibernateSessionFactory.getSession();
            Transaction ts = session.beginTransaction();
            List list = session.createQuery("from Kcb order by kch").list();
            ts.commit();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
