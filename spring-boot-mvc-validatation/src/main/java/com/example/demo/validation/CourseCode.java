package com.example.demo.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

/*
 * If we want to make an annotation then we should define with @Interface
 *  CourseCodeConstraintValidator.class : - Helper class that contains business rules/ validation logic
 *  
 *  @Target:- mean where we can apply this annotation
 *  
 *  @Retention:- It's mean how long this annotation will retain.
 *  Here we are using RUNTIME means keep this annotation in the compiled java bytecode
 *  during Runtime.
 */


@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
	
	//define default course code
	public String value() default "LUV";
	
	//define default error message
	public String message() default "must start with LUV";
	
	//define default group
	public Class<?>[] groups() default {};
	
	//define default payloads
	/*
	 * Payloads: provide custom details about validation failure
	 * (severity level, error code etc)
	 */
	public Class<? extends Payload>[] payload() default {};
	
}











































