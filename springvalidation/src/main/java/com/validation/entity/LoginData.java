package com.validation.entity;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class LoginData {
	
	@NotBlank(message = "User name cannot be empty")
	@Size(min=3, max=12, message = "User name must be between 3 -12 charcters")
	private String userName;
	
	@Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
	private String email;
	
	
	@AssertTrue(message = "Must Agree term and condition")
	private boolean aggreed;
	
	
	public LoginData() {
		// TODO Auto-generated constructor stub
	}


	public LoginData(String userName, String email) {
		super();
		this.userName = userName;
		this.email = email;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	


	public boolean isAggreed() {
		return aggreed;
	}


	public void setAggreed(boolean aggreed) {
		this.aggreed = aggreed;
	}


	@Override
	public String toString() {
		return "LoginData [userName=" + userName + ", email=" + email + "]";
	}
	
	

}
