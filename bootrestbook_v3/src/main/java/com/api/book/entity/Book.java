package com.api.book.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private int id;
	
	@Column(name = "title")
	private String title;
	
	/*
	 * @JsonManagedReference is only used for parent class and @JsonBackReference
	 * used for child class.
	 * 
	 * here we can see that book class has the refernce of Author class
	 * and Author class also has the reference for Book class.
	 * so, our code will get print recursilvly it goes to Book then Author
	 * and then Book and so on......
	 * so, with the help of @JsonManagedReference and JsonBackReference we can avoid this.
	 * https://www.youtube.com/watch?v=Tvvt9coRlF4&list=PL0zysOflRCelmjxj-g4jLr3WKraSU_e8q&index=25&ab_channel=LearnCodeWithDurgesh 
	 */
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "author_id")
	@JsonManagedReference
	private Author author;
	
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	

	public Book(int id, String title, Author author) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
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


	public Author getAuthor() {
		return author;
	}


	public void setAuthor(Author author) {
		this.author = author;
	}



	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
	}
	
	
	
	
}
