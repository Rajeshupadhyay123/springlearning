package com.rajesh.spring.demo.springlearningone.dao;

import java.util.List;

import com.rajesh.spring.demo.springlearningone.entity.Employee;

public interface EmployeeDao {

	List<Employee> findAll();

	Employee findById(int id);

	Employee save(Employee employee);

	void deleteById(int id);

}
