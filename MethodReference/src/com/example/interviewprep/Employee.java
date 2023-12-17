package com.example.interviewprep;

public class Employee {

	private String name;
	
	private int id;
	
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}


	public Employee(int id, String name) {
		super();
		this.name = name;
		this.id = id;
	}
	
	public String getEmployeeInfo() {
		return "I am a methods in Employee class";
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + "]";
	}
	
	
	
	
}
