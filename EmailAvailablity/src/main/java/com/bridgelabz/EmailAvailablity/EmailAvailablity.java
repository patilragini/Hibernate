package com.bridgelabz.EmailAvailablity;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmailAvailablity {
	
	private static Registration registration = null;
	private static SessionFactory factory;
	/**
	 * @param email
	 * @param password
	 * @return name
	 *         <p>
	 *         This function accepts user email id and password checks in
	 *         database if exist or not. If the user email id and password is
	 *         found in database ,it will return name of user.
	 */

	public static boolean validate(String email) {
		factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		TypedQuery<Registration> query = session.createQuery("select R.email from Registration R where email=:email");
		query.setParameter("email", email);
		List<Registration> list = query.getResultList();
		if (list.isEmpty()) {
		 return false;

		} else {
			session.close();
			String a = list.toString();
			System.out.println("here" + a);
			return true;
		}

	}
	
	
	
	
	
	

}
