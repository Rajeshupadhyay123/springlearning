package com.spring.rajesh.jpahibernate.dao;

import java.util.List;

import com.spring.rajesh.jpahibernate.entity.Student;

public interface StudentDao {

	void save(Student thestudent);
	
	Student findbyId(Integer id);
	
	Student findByLastName(String lastname);
	
	List<Student> findAll();
	
	
	Integer updatLastNameById(String lastName,int id);
	
	void update(Student student);
	
	void delete(Integer id);
	
	int deleteAll();
}




/*
 *JPA Entity Manager:-
 *Our JPA Entity Manager needs a Data Source
 *The Data Source define database connection info
 *JPA Entity Manager and Data Source are auto created by Spring Boot
 *     based on application.properties (JDBC URL)
 * 
 *     
 * Spring @Transactional
 * Spring provides an @Transactional annotation
 * Automagically begin and end a transation for your JPA code
 * No need for you to explicitly do this in your code 
 * 
 * Spring provide the @Repository which is a sub package of @Component
 * It support the component scanning
 * Translate JDBC exceptions
 */
