import com.shengxi.leung.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * @Author: matthew
 * @ClassName TestHibernate
 * @Date: 2019-10-01 23:40
 * @Version: 1.0.0
 * @description: 实例6-1
 */
public class TestHibernate {

    @Test
    public void Test() {
        //生成sessionFactory
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        //生成session
        Session session = sessionFactory.openSession();
        //开启事务管理
        Transaction tx = session.beginTransaction();
        try {

            Student student = new Student();
            student.setSid(1);
            student.setSname("lyh");
            //调用save方法，实现插入一个数据
            session.save(student);
            //提交事务
            tx.commit();
        } catch (SessionException e) {
            //出错就回滚整个事务
            //原理：利用数据库的数据库的事务管理系统，原子性，隔离性，一致性，持久性
            tx.rollback();
            e.printStackTrace();
        } finally {
            //使用完后关闭session，释放资源。避免资源不足。
            if (null != session) {
                session.close();
            }
        }
    }


}
