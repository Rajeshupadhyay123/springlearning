package com.rajesh.spring.demo.springlearningone.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajesh.spring.demo.springlearningone.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents=null;
	
	//define @PostContructor to load the student data... only once!
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<Student>();
		theStudents.add(new Student("Rajesh", "Upadhyay"));
		theStudents.add(new Student("Raj", "Singh"));
		theStudents.add(new Student("Ramesh", "Dama"));
	}

	// define endPoint for "/student"

	@GetMapping("/students")
	public List<Student> getStudents() {
		return theStudents;
	}
	
	//define endPoint or "/student/{studentsId}
	@GetMapping("/student/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		//just index into the list
		
		//check the studentId against the list size
		
		if((studentId>=theStudents.size()) || (studentId<0)) {
			throw new StudentNotFoundException("student is not found--"+studentId);
		}
		return theStudents.get(studentId);
	}
	
}






