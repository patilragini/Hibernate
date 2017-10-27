package com.bridgelabz.OneToOne;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 

 
public class Test {
 
    private static SessionFactory factory;       
    public static void main(String args[])
    {
        Configuration cfg = new Configuration().configure();
        factory = cfg.buildSessionFactory();
  
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
 
        Passport passport = new Passport();
        passport.setNumber("123");
        
        Person person = new Person();
        person.setName("abc123");
        person.setPassport(passport);
 
        session.save(passport);
        int personId = (Integer)session.save(person);
 
        tx.commit();        
        session.close();
 
        getPersonDetails(personId);        
        factory.close();        
    }
   
    private static void getPersonDetails(int id)
    {
        Session session = factory.openSession();        
        Person person = (Person)session.get(Person.class,id);        
        Passport passport  = person.getPassport();
 
        String name = person.getName();
        String number=passport.getNumber();
        System.out.println("Person Name =" +  name);
        System.out.println("Passport Number = " + number);
    }
}