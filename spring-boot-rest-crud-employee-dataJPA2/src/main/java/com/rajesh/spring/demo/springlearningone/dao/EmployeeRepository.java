package com.rajesh.spring.demo.springlearningone.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.rajesh.spring.demo.springlearningone.entity.Employee;

//Here Employee is Entity Type and Integer is primary key

/*
 * Here if we will not use the @RepositoryRestResource then spring will call the services
 * for the plural form of entity.
 * like:-
 * for Entity :- Employee, it calles on employees, add "s" in the end
 * But while using this annotation we can custom define.
 * so we can called on /members
 */

//@RepositoryRestResource(path = "memebrs")
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	

	
}
