package com.bridgelabz.Loading;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Loading {
	public static void main(String args[]){
		Configuration cfg = new Configuration().configure();        
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
 
        Book book = (Book)session.get(Book.class, 5);
        System.out.println(Book.class);
        System.out.println(book);
        System.out.println("Book Name =" + book.getName());
		System.out.println("Book Author =" + book.getAuthor());
        System.out.println("Fetching Book with isbn number 5 ");
        System.out.println();
        book = (Book)session.get(Book.class, 6);
        System.out.println(book);
        System.out.println("Book Name =" + book.getName());
		System.out.println("Book Author =" + book.getAuthor());
        System.out.println("Fetching Book with isbn number 6 ");
        System.out.println(book);
        book = (Book)session.load(Book.class, 1);
        System.out.println("Book Name =" + book.getName());
		System.out.println("Book Author =" + book.getAuthor());
		 System.out.println("Fetching Book with isbn number 5 ");
        factory.close();
	}

}
