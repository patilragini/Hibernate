package com.bridgelabz.ManyToMany;

import java.util.HashSet;
import java.util.Set;

public class Role {
	 private int id;    
     private String name;
     private Set<Employee> employee= new HashSet<Employee>();
     public int getId() {
        return id;
     }
     public void setId(int id) {
        this.id = id;
     }
     public String getName() {
        return name;
     }
     public void setName(String name) {
        this.name = name;
     }
     public Set<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(Set<Employee> employee) {
		this.employee=employee;
	}
	@Override
     public String toString() {
        return "Role [id=" + id + ", name=" + name + "]";
     }
    
}
