package com.rajesh.spring.demo.springlearningone.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajesh.spring.demo.springlearningone.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	//add method to sort by last name
	
	/*
	 * Here Data JPA read this method as findAll by orderByLastName
	 * it automatically become from "Employee order by lastName asc"
	 * 
	 * However we can also use the @Query(select *from Employee order by lastName) 
	 * method for this
	 */ 
	public List<Employee> findAllByOrderByLastName();

}
