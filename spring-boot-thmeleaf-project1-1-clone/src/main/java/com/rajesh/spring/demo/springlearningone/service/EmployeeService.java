package com.rajesh.spring.demo.springlearningone.service;

import java.util.List;

import com.rajesh.spring.demo.springlearningone.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();
	
	void saveEmployee(Employee employee);
	
	Employee findById(int id);
	
	void deleteEmployee(int id);
	
}
