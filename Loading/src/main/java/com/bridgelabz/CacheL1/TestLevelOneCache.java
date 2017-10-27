package com.bridgelabz.CacheL1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestLevelOneCache {

	public static void main(String args[]) {
		int id;
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();
		Student student = new Student();
		student.setName("kamini");
		id = (Integer) session.save(student);
		tx.commit();	
		session.close();

		session = factory.openSession();
		tx = session.beginTransaction();
		Student st2 = (Student) session.get(Student.class, id);//eager
		System.out.println(st2.getName());
		Student st3 = (Student) session.get(Student.class, id);
		System.out.println(st3.getName());
		Student st5 = (Student) session.get(Student.class, id);
		System.out.println(st5.getName());
		Student st6 = (Student) session.load(Student.class, id);//lazy
		System.out.println(st6.getName());
		tx.commit();
		session.close();

		session = factory.openSession();
		Student st4 = (Student) session.get(Student.class, id);
		session.close();
		factory.close();
	}
}
