package dao.imp;
import dao.DlDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import model.Dlb;
public class DlDaoImp implements DlDao {
	public Dlb validate(String xh, String kl) {
		try{
			Session session=util.HibernateSessionFactory.getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("from Dlb where xh=? and kl=?");
			query.setParameter(0, xh);
			query.setParameter(1, kl);
			query.setMaxResults(1);
			Dlb dlb=(Dlb) query.uniqueResult();
			if(dlb!=null){
				return dlb;
			}else{
				return null;
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}

