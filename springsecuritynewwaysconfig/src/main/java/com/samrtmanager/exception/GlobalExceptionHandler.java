package com.samrtmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ExceptionResposne> getUserNotFoundExceptionHandle
	(UserNotFoundException exception){
		
		ExceptionResposne response = new ExceptionResposne();
		response.setMessage(exception.getMessage());
		response.setStatus(HttpStatus.BAD_REQUEST.toString());
		
		return new ResponseEntity<ExceptionResposne>(response,HttpStatus.BAD_REQUEST);
		
		
		
	}
	
}
