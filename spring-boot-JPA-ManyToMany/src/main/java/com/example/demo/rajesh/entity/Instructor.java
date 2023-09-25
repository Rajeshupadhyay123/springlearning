package com.example.demo.rajesh.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "instructor")
public class Instructor {
	
	// annotate the class as an entity and map to db table

	// define the fields

	// annotate the field with db column name

	// generate getter/setter

	// generate toString() methods
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	//one to one mapping for field instructor_detail_id 
	//to table instructor_detail tables
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "instructor_detail_id")
	private InstructorDetail instructorDetail;
	
	
	/*
	 * For OneToMany mapping, the fetchtype is by-default 'LAZY'
	 * so, Only for readbility I added here 'LAZY'
	 */
	@OneToMany(mappedBy = "instructor",
			fetch = FetchType.LAZY,
			cascade = {CascadeType.PERSIST, CascadeType.MERGE,
					   CascadeType.DETACH, CascadeType.REFRESH})
	private List<Course> courses;
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}



	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}

	


	public List<Course> getCourses() {
		return courses;
	}



	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}


	//add method for bi-directional releationship
	
	public void add(Course newCourse) {
		if(courses == null) {
			courses = new ArrayList<Course>();
		}
		
		courses.add(newCourse);
		newCourse.setInstructor(this);
		
	}

	public Instructor() {
		// TODO Auto-generated constructor stub
	}



	public Instructor(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}



	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", instructorDetail=" + instructorDetail + "]";
	}
	
	
	
	

}
