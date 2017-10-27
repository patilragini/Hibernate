package com.bridgelabz.Level1;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestLevelOneCache {

	public static void main(String args[]) {
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Student student = new Student();
		student.setName("Ragini");
		int id = (Integer) session.save(student);

		tx.commit();
		session.close();

		session = factory.openSession();
		//no same statement will process
		Student st1 = (Student) session.get(Student.class, id);
		Student st2 = (Student) session.get(Student.class, id);
		session.close();

		session = factory.openSession();
		Student st3 = (Student) session.get(Student.class, id);
		session.close();
		factory.close();
	}
}
