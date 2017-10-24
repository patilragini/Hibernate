package com.bridgelabz.Hibernate1;


import java.util.Properties;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class TestStudent {
 
     public static void main(String a[])
    {
 
       Properties property = new Properties();        
       property.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
       property.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
       property.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/Maven");
       property.setProperty("hibernate.connection.username", "root");
       property.setProperty("hibernate.connection.password", "root");
       property.setProperty("hibernate.hbm2ddl.auto", "update");
       property.setProperty("hibernate.show_sql", "true");
 
       Configuration configuration = new Configuration();        
       configuration.addResource("student.hbm.xml");
       
       configuration.setProperties(property);        
       Student s = new Student();        
       s.setName("student1");
 
       SessionFactory factory = configuration.buildSessionFactory();
 
       Session session = factory.openSession();
       Transaction transaction=session.beginTransaction();
       session.save(s);
       s.setName("studen987");
 
       transaction.commit();
       session.close();
       factory.close();
    }
}