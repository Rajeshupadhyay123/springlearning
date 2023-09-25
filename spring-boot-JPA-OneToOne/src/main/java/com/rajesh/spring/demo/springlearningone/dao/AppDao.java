package com.rajesh.spring.demo.springlearningone.dao;

import com.rajesh.spring.demo.springlearningone.entity.Instructor;

public interface AppDao {

	void save(Instructor instructor);
	
	Instructor findInstructorById(int id);
	
	void deleteInstructorById(int id);
}
