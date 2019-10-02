import com.shengxi.leung.model.SeatEntity;
import com.shengxi.leung.model.Student;
import com.shengxi.leung.model.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;

/**
 * @Author: matthew
 * @ClassName TestHibernate
 * @Date: 2019-10-01 23:40
 * @Version: 1.0.0
 * @description: 实例6-1
 */
public class TestHibernate {

    /**
     * 6-1
     */
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

    /**
     * 6-2
     */
    @Test
    public void Test62() {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = null;
        Transaction tx = null;
        try {
            Student stu = new Student(004, "wangwu");
            session = sf.openSession();
            tx = session.beginTransaction();
            session.save(stu);
            tx.commit();
            Query query = session.createQuery("from Student where sid=004");
            List<Student> list = query.list();
            Student student = list.get(0);
            System.out.println(student.toString());
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            if (null != session) {
                session.close();
            }
        }

    }


    @Test
    public void Test63(){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = null;
        Transaction transaction = null;
        try{
            SeatEntity seatEntity = new SeatEntity();
            seatEntity.setPlace("三排一列");
            SeatEntity seatEntity1 = new SeatEntity();
            seatEntity1.setPlace("三排二列");
            UserEntity userEntity = new UserEntity();
            userEntity.setName("lyh");
            userEntity.setSeats(new HashSet<SeatEntity>());
            userEntity.addSeat(seatEntity);
            userEntity.addSeat(seatEntity1);
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(userEntity);
            transaction.commit();
            System.out.println("操作成功");
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            if (null != session){
                session.close();
            }
        }
    }

}
