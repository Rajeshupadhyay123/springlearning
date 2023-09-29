package com.example.demo;

import com.example.demo.validation.CourseCode;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Customer {

	private String firstName;
	
	
	@NotNull(message = "is required")
	@Size(min=1, message = "is required")
	private String lastName="";


	/*
	 * If this field must be 1 to 10
	 */
	@NotNull(message = "is required")
	@Min(value = 0, message = "must be greater than or equal to zero")
	@Max(value = 10, message = "must be less than or equal to 10")
	private Integer freePasses;
	
	
	/*
	 * Adding regular expression
	 */
	@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 chars/digits")
	private String postalCode;
	
	//this is our custom code
	/*
	 * Value:- The value the course code must start with
	 * message:- Error message if validation fails
	 * courseCode:- field in our class
	 */
	@CourseCode(value = "TOPS", message = "must start with TOPS")
	private String courseCode;
	
	
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

	

	public Integer getFreePasses() {
		return freePasses;
	}


	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}


	public String getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	


	public String getCourseCode() {
		return courseCode;
	}


	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}


	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
}
































