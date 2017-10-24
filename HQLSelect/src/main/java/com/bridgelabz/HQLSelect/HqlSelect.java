package com.bridgelabz.HQLSelect;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HqlSelect {
	private static SessionFactory factory = null;
	public static void main(String[] args) {
		factory = new Configuration().configure().buildSessionFactory();
		System.out.println(factory);
		
		
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx =  session.beginTransaction();
			List<Customer> customers =  session.createQuery("FROM Customer").list();
			customers.forEach(System.out::println);
			tx.commit();
		}catch(Exception e){
			if(null != tx){
				tx.rollback();
			}
		}finally{
			session.close();
		}

	}

}
