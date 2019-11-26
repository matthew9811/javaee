package dao.imp;
import java.util.List;
import dao.ZyDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import model.Zyb;
public class ZyDaoImp implements ZyDao{
	public Zyb getOneZy(Integer zyId) {
		try{
			Session session=org.util.HibernateSessionFactory.getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("from Zyb where id=?");
			query.setParameter(0, zyId);
			query.setMaxResults(1);
			Zyb zy=(Zyb) query.uniqueResult();
			ts.commit();
			org.util.HibernateSessionFactory.closeSession();
			return zy;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public List getAll() {
		try{
			Session session=org.util.HibernateSessionFactory.getSession();
			Transaction ts=session.beginTransaction();
			List list=session.createQuery("from Zyb").list();
			ts.commit();
			org.util.HibernateSessionFactory.closeSession();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
