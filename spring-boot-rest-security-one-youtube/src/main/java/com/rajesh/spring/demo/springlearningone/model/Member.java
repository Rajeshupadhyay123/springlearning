package com.rajesh.spring.demo.springlearningone.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "members")
public class Member {

	@Column(name = "user_id")
	private String user_id;
	
	@Column(name = "pw")
	private String password;
	
	@Column(name = "active")
	private int active;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String user_id, String password, int active) {
		super();
		this.user_id = user_id;
		this.password = password;
		this.active = active;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Member [user_id=" + user_id + ", password=" + password + ", active=" + active + "]";
	}
	
	
	

}