package com.bridgelabz.Availablity;

import java.util.List;
import java.util.regex.Pattern;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class EmailAvailablity {

	private static Registration registration = null;
	private static SessionFactory factory;

	/**
	 * @param email
	 * @param password
	 * @return boolean
	 *         <p>
	 *         This function accepts user email id and password checks in
	 *         database if exist or not. If the user email id and password is
	 *         found in database ,it will return name of user.
	 */

	public static boolean validate(String email) {		
		Configuration cfg=new Configuration();
		System.out.println(cfg);
		cfg.configure();
		System.out.println(cfg);
		factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Query query = session.createQuery("select R.email from Registration R where email=:email");
		query.setParameter("email", email);
		List<Registration> list = query.getResultList();
		System.out.println(list);
		if (list.isEmpty()) {
			return false;
		} else {
			session.close();
			String a = list.toString();
			System.out.println("here" + a);
			return true;
		}

	}

	public static boolean checkemail(String email) {
		String regexEmail = "[a-z0-9]{1,}[@]{1}[a-z]{1,}[.]{1}[a-z]{1,}";
		if (Pattern.matches(regexEmail, email) == false || email == "") {
			return false;
		}
		return true;
	}

}
