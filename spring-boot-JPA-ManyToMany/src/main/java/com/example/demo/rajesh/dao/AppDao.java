package com.example.demo.rajesh.dao;

import java.util.List;

import com.example.demo.rajesh.entity.Course;
import com.example.demo.rajesh.entity.Instructor;
import com.example.demo.rajesh.entity.Student;



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
	
	
	void save(Course course);
	
	
	Course findCourseAndReviewByCourseId(int id);
	
	Course findCourseAndStudentByCourseId(int id);
	
	Student findStudentAndCoursesByStudentId(int id);
	
	void update(Student student);
	
	void deleteStudentById(int id);
}























