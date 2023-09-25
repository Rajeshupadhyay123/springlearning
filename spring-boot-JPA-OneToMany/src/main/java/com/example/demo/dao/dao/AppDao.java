package com.example.demo.dao.dao;

import java.util.List;

import com.example.demo.dao.entity.Course;
import com.example.demo.dao.entity.Instructor;

public interface AppDao {

	void save(Instructor instructor);
	
	Instructor findInstructorById(int id);
	
	void deleteInstructorById(int id);
	
	List<Course> findCoursesByInstructorId(int id);
	
	
	Instructor findInstructorByIdJoinFetch(int id);
	
	void update(Instructor instructor);
	
	void update(Course course);
	
	Course findCourseById(int id);
	
	void deleteCourseById(int id);
}
