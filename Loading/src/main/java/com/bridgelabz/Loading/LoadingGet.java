package com.bridgelabz.Loading;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LoadingGet {

	public static void main(String a[]) {
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
//		 Book book = new Book(); book.setName("pqr");
//		 book.setAuthor("pqr123");
//		 session.save(book);
		 
		Book book = (Book) session.get(Book.class, 6);
		System.out.println();
		System.out.println("Book Name =" + book.getName());
		System.out.println("Book Author =" + book.getAuthor());

		System.out.println("Fetching Book with isbn number 5 ");
		System.out.println();
		
		 /** method calls the database to find the object associated with the
		 * given identifier. In case object does not found, returns null.*/
		 
		book = (Book) session.get(Book.class, 5);
		System.out.println();
		tx.commit();
		session.close();
		factory.close();
	}
}
