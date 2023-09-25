package com.spring.rajesh.jpahibernate.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.rajesh.jpahibernate.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDaoImp implements StudentDao {
	
	//define field for entity manager
	private EntityManager entityManager;
	
	//inject entity manager using constructor injection
	@Autowired
	public StudentDaoImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	@Override
	@Transactional
	public void save(Student thestudent) {
		entityManager.persist(thestudent);
	}


	@Override
	public Student findbyId(Integer id) {
		return entityManager.find(Student.class, id);
	}

	

	/*
	 * Here Student is a entity class name not database table name
	 * also, lastName is entity class parameter name not a database table column name as last_name
	 */
	@Override
	public Student findByLastName(String lastname) {
		
		//Creating query
		TypedQuery<Student> theQuery =
				entityManager.createQuery("FROM Student where lastName=?1", Student.class);
		theQuery.setParameter(1, lastname);

		return theQuery.getSingleResult();
	}


	@Override
	public List<Student> findAll() {
		TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student",Student.class);
		return theQuery.getResultList();
	}


	@Override
	@Transactional
	public void update(Student student) {
		entityManager.merge(student);
		
	}


	@Override
	@Transactional
	public void delete(Integer id) {
		
//		//retrieve the student
//		Student student = entityManager.find(Student.class, id);
//		
//		//delete the student
//		entityManager.remove(student);
		
		Query theQuery= 
				entityManager.createQuery("DELETE FROM Student where id=?1");
		theQuery.setParameter(1, id);
		theQuery.executeUpdate();
		
	}


	@Override
	@Transactional
	public int deleteAll() {
		
		int numRowDeleted = 
				entityManager.createQuery("DELETE FROM Student").executeUpdate();
		return numRowDeleted;
	}


	@Override
	@Transactional
	public Integer updatLastNameById(String lastName,int id) {
		
		Query theQuery = 
				entityManager.createQuery("UPDATE Student SET lastName=?1 where id=?2");
		
		theQuery.setParameter(1, lastName);
		theQuery.setParameter(2, id);
		
		return theQuery.executeUpdate();
	}



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

