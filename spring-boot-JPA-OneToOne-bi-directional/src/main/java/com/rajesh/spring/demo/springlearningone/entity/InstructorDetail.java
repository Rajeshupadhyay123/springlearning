package com.rajesh.spring.demo.springlearningone.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

	//annotate the class as an entity and map to db table
	
	
	//define the fields
	
	
	//annotate the field with db column name
	
	//generate getter/setter
	
	//generate toString() methods
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "youtube_channel")
	private String youtubeChannel;
	
	@Column(name = "hobby")
	private String hobby;
	
	/*
	 * this is for making code bi-directional, because we have already create
	 * oneToOne mapping for instructor class for getting instructorDetail class, and
	 * now we are creating the flow for getting instructor class from instructorDetail class
	 */
	
	//add @oneToOne annotation
	@OneToOne(mappedBy = "instructorDetail", 
			cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
	private Instructor instructor;
	
	
	
	public InstructorDetail() {
		// no-args constructor
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public InstructorDetail(String youtubeChannel, String hobby) {
		super();
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + "]";
	}
	
}
