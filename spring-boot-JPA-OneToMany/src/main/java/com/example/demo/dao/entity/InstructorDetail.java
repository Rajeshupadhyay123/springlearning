package com.example.demo.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

	//annotate the class as an entity and map to db table
	
	
	//define the fields
	
	
	//annotate the field with db column name
	
	//generate getter/setter
	
	//generate toString() methods
	
	/*
	 * Note:-
	 * If there is a field which is a foreign key of some other table
	 * then, don't init that field here.
	 * i.e:- In this InstructorDetail table, there is a field name:= 
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "youtube_channel")
	private String youtubeChannel;
	
	@Column(name = "hobby")
	private String hobby;
	
	public InstructorDetail() {
		// no-args constructor
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
