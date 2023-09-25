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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

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
	
	
	/*
	 * Let's understand the @JoinTable annotation
	 * If we go for many to many relationship then we must have to create a table middle
	 * of them, which has the information about both table in many relationship.
	 * In our case, "course_student" is a table have the information about table 'Course'
	 * and 'Student' as their primary key and foreign key for both table.
	 * 
	 * Now, inside the @JoinTable annotation, JoinColumns have the name of current table name
	 * such as Course in this class, and inverseJoinColumn has the table which are present into
	 * the other side of the relation, such as 'Student'.
	 * 
	 * So, inside the course_student table, course_id is foreign key to course table
	 * and student_id is foreign key to the  student table
	 */
	
	
	@ManyToMany(fetch = FetchType.LAZY , 
			cascade =  {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
			name = "course_student",
			joinColumns = @JoinColumn(name = "student_id"),
			inverseJoinColumns = @JoinColumn(name = "course_id")
		)
	private List<Course> courses;
	
	
	
	



	public Student() {
		// TODO Auto-generated constructor stub
	}



	public Student(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}



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
	
	public List<Course> getCourses() {
		return courses;
	}



	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	//add convenience method
	public void addCourse(Course course) {
		
		if(courses == null) {
			courses = new ArrayList<Course>();
		}
		
		courses.add(course);
	}



	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	
	
}





















