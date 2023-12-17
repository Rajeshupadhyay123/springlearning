package com.example.interviewprep;

public class EmployeeDao {
	
private String name;
	
	private int id;
	
	public EmployeeDao() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeDao(String name, int id) {
		super();
		this.name = name;
		this.id = id;
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
		return "EmployeeDao [name=" + name + ", id=" + id + "]";
	}
	
	

}
