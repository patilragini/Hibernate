package com.bridgelabz.ManyToMany;

import java.util.HashSet;
import java.util.Set;
 
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
  
        Role role1 = new Role();
        role1.setName("Engineer");   
        
        Role role2 = new Role();
        role2.setName("accounts");
 
        Set<Role> roles = new HashSet<Role>();
 
        roles.add(role2);
        roles.add(role1);
  
        Employee employee = new Employee();
        employee.setName("lmn");
        employee.setRoles(roles);
 
        session.save(role1);
        session.save(role2);
 
        int empId = (Integer)session.save(employee);
 
        tx.commit();        
        session.close();
 
        getEmployeeDetails(empId);
        factory.close();        
    }
 
    private static void getEmployeeDetails(int id)
    {
        Session session = factory.openSession();        
        Employee employee = (Employee)session.get(Employee.class,id);
  
        String name= employee.getName();
        Set<Role> roles = employee.getRoles();
        System.out.println(name);
        System.out.println(roles);        
    }
}