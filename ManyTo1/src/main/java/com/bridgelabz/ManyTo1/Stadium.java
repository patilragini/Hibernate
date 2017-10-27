package com.bridgelabz.ManyTo1;

public class Stadium {
	
	private int id;
	private String name;
	private int capacity;
	private String country;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity=capacity;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country=country;
	}
	@Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", country=" + country
                + ", capacity=" + capacity + "]";
    }                

}