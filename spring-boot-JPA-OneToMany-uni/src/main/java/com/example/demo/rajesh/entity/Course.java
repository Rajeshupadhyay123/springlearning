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
	 */
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id")
	private List<Review> reviews;
	
	
	
	

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
	
	
	//add convience method
	
	public void addReview(Review review) {
		
		if(reviews == null) {
			reviews = new ArrayList<Review>();
		}
		
		reviews.add(review);
	}
	
	

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + "]";
	}
	
	
}
















