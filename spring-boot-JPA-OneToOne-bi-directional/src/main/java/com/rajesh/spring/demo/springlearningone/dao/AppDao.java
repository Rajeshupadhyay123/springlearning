package com.rajesh.spring.demo.springlearningone.dao;

import com.rajesh.spring.demo.springlearningone.entity.Instructor;
import com.rajesh.spring.demo.springlearningone.entity.InstructorDetail;

public interface AppDao {

	void save(Instructor instructor);
	
	Instructor findInstructorById(int id);
	
	void deleteInstructorById(int id);
	
	InstructorDetail findInstructorDetailById(int id);
	
	void deleteInstructorDetailById(int id);
}
