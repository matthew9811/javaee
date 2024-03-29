package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestHibernate {
    public static void main(String[] args) {

        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        Session s = sf.openSession();
        s.beginTransaction();

        Product p = new Product();
        p.setName("iphone7");
        p.setPrice(7000);
        s.save(p);

        s.getTransaction().commit();
        s.close();
        sf.close();
    }
}
