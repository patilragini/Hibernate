package com.bridgelabz.SimpleMaven;

import javax.persistence.Id;

import org.hibernate.annotations.Entity;

@SuppressWarnings("deprecation")
@Entity  

public class Employee {

	private String firstName,lastName;  
	@Id  
	private int id;  
	public int getId() {  
	    return id;  
	}  
	public void setId(int id) {  
	    this.id = id;  
	}  
	public String getFirstName() {  
	    return firstName;  
	}  
	public void setFirstName(String firstName) {  
	    this.firstName = firstName;  
	}  
	public String getLastName() {  
	    return lastName;  
	}  
	public void setLastName(String lastName) {  
	    this.lastName = lastName;  
	}  
}
