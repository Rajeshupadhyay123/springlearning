package com.rajesh.spring.demo.springlearningone.service;

import java.util.List;

import com.rajesh.spring.demo.springlearningone.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();
	
	Employee findById(int id);
	
	Employee save(Employee employee);
	
	void deleteById(int id);
}
