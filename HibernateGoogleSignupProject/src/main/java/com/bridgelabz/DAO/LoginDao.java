/****************************************************************************** 
 *  @author  Ragini Patil
 *  @version 1.0
 *  @since   5-10-2017
 *	@purpose LoginDao is class responsible for Database related operations
 *			 while loging in.
 *			
 *			 
 ******************************************************************************/
package com.bridgelabz.DAO;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bridgelabz.Model.Registration;

public class LoginDao {
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

	public static String validate(String email, String password) {
		factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		TypedQuery<Registration> query = session.createQuery("select R.name from Registration R where email=:email AND password=:password");
		query.setParameter("email", email);
		query.setParameter("password", password);
		List<Registration> list = query.getResultList();
		if (list.isEmpty()) {
			return null;

		} else {

			session.close();
			String a = list.toString();
			System.out.println("here" + a);
			return a;
		}

	}

}
