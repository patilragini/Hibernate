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
        role1.setName("Account");  
   
        
        Role role2 = new Role();
        role2.setName("CEO123");
 
        Set<Role> roles = new HashSet<Role>();
 
        roles.add(role2);
        roles.add(role1);
        /*System.out.println("1st");
        
        session.save(roles);*/
  
        Employee employee = new Employee();
        employee.setName("geeta");
        employee.setRoles(roles);
 
        session.save(role1);
        session.save(role2);
 
        /*int empId = (Integer)session.save(employee);*/
        
        Employee employee2 = new Employee();
        employee2.setName("kamini");
        
        Set<Employee> emp=new HashSet<Employee>();
        emp.add(employee);
        emp.add(employee2);
        
        role1.setEmployee(emp);
        
       /* System.out.println("2nd");*/
        /*session.save(emp);*/
        session.save(employee);
        session.save(employee2);
        
        tx.commit();        
        session.close();
 
        /*getEmployeeDetails(empId);*/
        factory.close();        
    }
 
    /*private static void getEmployeeDetails(int id)
    {
        Session session = factory.openSession();        
        Employee employee = (Employee)session.get(Employee.class,id);
  
        String name= employee.getName();
        Set<Role> roles = employee.getRoles();
        System.out.println(name);
        System.out.println(roles);        
    }*/
}