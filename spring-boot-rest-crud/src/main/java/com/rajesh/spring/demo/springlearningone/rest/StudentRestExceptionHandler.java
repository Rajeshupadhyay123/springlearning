package com.rajesh.spring.demo.springlearningone.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handlerException(StudentNotFoundException exe){
		
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exe.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		
		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exe){
		
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exe.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<StudentErrorResponse>(error,HttpStatus.BAD_REQUEST);
	}
}
