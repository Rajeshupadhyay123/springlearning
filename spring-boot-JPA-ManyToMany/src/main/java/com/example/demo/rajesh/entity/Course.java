package com.example.demo.rajesh.entity;



import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.Generated;
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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;

@Entity
@Table(name = "course")
public class Course {

	//define our fields
	
	//define constructor
	
	//define getter / setter
	
	//annotate field
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "title")
	private String title;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
						CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "instructor_id")
	private Instructor instructor;
	
	
	/*
	 * Why JoinColumn --> It tell Hibernate to Review table that
	 * point to Course table for join on the behalf of "course_id" present into Review Table
	 * 
	 * Here we are using CascasdeType.ALL because we want to also delete
	 * Review if Courses are deleted
	 * 
	 * Cascade means, if we make any changes into one table then it will also get effected into the other
	 * table. And the changes are get effected into the database
	 */
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id")
	private List<Review> reviews;
	
	
	/*
	 * Let's understand the @JoinTable annotation
	 * If we go for many to many relationship then we must have to create a table middle
	 * of them, which has the information about both table in "many" relationship.
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
			joinColumns = @JoinColumn(name = "course_id"),
			inverseJoinColumns = @JoinColumn(name = "student_id")
		)
	private List<Student> students;
	
	

	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(String title) {
		super();
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	
	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
	

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
	//add convience method
	
	public void addReview(Review review) {
		
		if(reviews == null) {
			reviews = new ArrayList<Review>();
		}
		
		reviews.add(review);
	}
	
	
	//add method
	public void addStudent(Student student) {
		
		if(students == null) {
			students = new ArrayList<Student>();
		}
		
		students.add(student);
	}
	
	

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + "]";
	}
	
	
}
















