package com.example.demo.rajesh.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "review")
public class Review {

	//define field
	
	//define constructor
	
	//define getter/setter
	
	//define toString()
	
	//annotation field
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	
	@Column(name = "comment")
	private String comment;
	
	
	
	
	
	public Review() {
		// TODO Auto-generated constructor stub
	}
	

	public Review(String comment) {
		super();
		this.comment = comment;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	@Override
	public String toString() {
		return "Review [id=" + id + ", comment=" + comment + "]";
	}
	
	
	
	
	
	
}




























