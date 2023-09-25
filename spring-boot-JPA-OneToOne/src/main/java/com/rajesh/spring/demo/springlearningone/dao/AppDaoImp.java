package com.rajesh.spring.demo.springlearningone.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.rajesh.spring.demo.springlearningone.entity.Instructor;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AppDaoImp implements AppDao {
	
	//define field for entity Manager
	private EntityManager entityManager;
	
	//inject entity manager using constructor injection
	@Autowired
	public AppDaoImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Instructor instructor) {
		entityManager.persist(instructor);
		
	}

	@Override
	public Instructor findInstructorById(int id) {
		
		return entityManager.find(Instructor.class, id);
		
	
	}

	@Override
	@Transactional
	public void deleteInstructorById(int id) {
		
		Instructor instructor = entityManager.find(Instructor.class, id);
		entityManager.remove(instructor);
		
	}
	
	

}




















