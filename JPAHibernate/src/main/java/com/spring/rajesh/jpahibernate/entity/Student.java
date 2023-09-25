package com.spring.rajesh.jpahibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	//define fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	
	@Column(name="last_name")
	private String lastName;
	
	
	@Column(name="email")
	private String email;


	
	//define constructor
	
	//no-argument constructors
	public Student() {
		
	}



	public Student(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	
	//define getter/setter

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


	//define toString method
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	
	
}


/*
 * The Entity class :-
 * Must be annotated with @@Entity
 * Must have a public or protected no-argument constructor
 * 
 * 
 * Actually, the use of @Column is optional
 * If not specified, the column name is same as java field
 * This is not recommend approach,
 * If you refactor the java code, then it will not match the existing database column
 * This is breaking change and you will need to update database column
 * 
 * Same applies to @Table, database table name is same as the class name
 * 
 * @Id is used for primary key, and it cannot be null
 * ID Generation Strategies:-
 * NAME                Description
 * GenerationType.AUTO   |   Pick an appropiate strategy for particular database
 * GenerationType.IDENTITY  | Assign primary key using database identity column
 * GenerationType.SEQUENCE  | Assign primary keys using database sequence
 * GenerationType.TABLE     | Assign primary keys using an underlying database table to ensure uniqueness
 * 
 * 
 */