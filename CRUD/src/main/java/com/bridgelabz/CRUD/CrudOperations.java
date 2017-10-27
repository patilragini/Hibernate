package com.bridgelabz.CRUD;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class CrudOperations {
	private static SessionFactory factory;

	public static void main(String[] args) {
		char choice = 'y';
		Scanner scanner = new Scanner(System.in);
		System.out.println("============Set up Session Factory============");
		setUpSessionFactory();
		int operation = 9;

		do {
			System.out.println("1.save\n2.show\n3.update\n4 delete\n5.find name \n6. shutdown");
			operation = scanner.nextInt();
			switch (operation) {
			case 1:
				System.out.println("============Save customer  Customers============");
				saveCustomers();
				break;
			case 2:
				System.out.println("============Show Customers============");
				showAllCustomers();
				break;
			case 3:
				System.out.println("============Update Customer ============");
				System.out.println("enter id and new age");
				// let id=1 pk and newage=80
				int id = scanner.nextInt();
				int newage = scanner.nextInt();
				updateCustomer(id, newage);
				break;
			case 4:
				System.out.println("============Delete Customer:  id ============");
				System.out.println("enter id");
				int idDelete = scanner.nextInt();
				deleteCustomer(idDelete);
				break;
			case 5:
				System.out.println("enter name to search");
				String name = scanner.next();
				String customer=findCustomers(name);
				String a=customer; 
				System.out.println("last name of customer is:"+a);				
				break;
			case 6:
				System.out.println("shutdown factory !!");
				shutdown();
				break;
			}

			System.out.println("continue??");
			choice = scanner.next().charAt(0);
		} while (choice == 'y');
	}

	public static void setUpSessionFactory() {
		// create sessionFactory
		try {
			factory = new Configuration().configure().buildSessionFactory();
			System.out.println(factory);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("factory errorr!!!");
		}
	}

	public static void shutdown() {
		factory.close();
	}

	public static void saveCustomers() {
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			System.out.println("enter name surname age");
			// create customers
			Scanner scanner = new Scanner(System.in);
			String name = scanner.next();
			String surnmae = scanner.next();
			System.out.println("age");
			int age = scanner.nextInt();
			Customer c1 = new Customer(1, name, surnmae, age);

			// save to database
			session.save(c1);
			transaction.commit();
		} catch (Exception e) {
			if (null != transaction) {
				transaction.rollback();
				System.out.println("Rollback !!!");
			}
		} finally {
			session.close();
		}
	}

	public static void showAllCustomers() {

		Session session = factory.openSession();
		String queryString = "from Customer ";
		Query<Customer> query = session.createQuery(queryString);
		List<Customer> customer = query.list();
		System.out.println("no of rows affected:" + customer.size());
		for (int i = 0; i < customer.size(); i++) {
			System.out.println(customer.get(i));
			System.out.println();
//			System.out.println("contains" + customer.contains("ragini"));
		}
			
		session.close();
	}

	public static String findCustomers(String name) {
		Session session = factory.openSession();
		Customer cust = new Customer();
		TypedQuery<Customer> query = session.createQuery("SELECT E.lastName from  Customer E where firstName=:firstName");
		// TypedQuery<Customer> query = session.createQuery("from Customer where
		// firstName=:firstName AND age=:age",
		// Customer.class);
		query.setParameter("firstName", name);
		List<Customer> customer = query.getResultList();
		
		System.out.println("no of rows affected:" + customer.size());
		session.close();		
		System.out.println("here"+customer.toString());
		return customer.toString();
		}

	public static void updateCustomer(int customerId, int newAge) {
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			// update whewre age = 21
			System.out.println(Customer.class);
			Customer cust = session.get(Customer.class, customerId);
			cust.setAge(newAge);
			session.update(cust);

			transaction.commit();
		} catch (Exception e) {
			if (null != transaction) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}

	public static void deleteCustomer(int customerId) {
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Customer cust = session.get(Customer.class, customerId);
			session.delete(cust);
			transaction.commit();
		} catch (Exception e) {
			if (null != transaction) {
				transaction.commit();
			}
		} finally {
			session.close();
		}
	}
}