package com.example.demo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/*
 * Here:-
 * CourseCode: it our annotation
 * String:- Type of data that to validate against
 */

public class CourseCodeConstraintValidator
 			implements ConstraintValidator<CourseCode, String>{

	
	private String coursePrefix;
	
	/*
	 * This methods first time call when we created the object of this class
	 */
	@Override
	public void initialize(CourseCode courseCode) {
		coursePrefix = courseCode.value();
	}
	
	/*
	 * Here
	 * code:- the HTML form data entered by the user
	 * constraintValidatorContext: you can place additional error message here
	 * 
	 * This isValid() methods decide whether the validation message need to display our.
	 * if boolean is 'true' then message will display else not
	 */
	
	@Override
	public boolean isValid(String code,
			ConstraintValidatorContext constraintValidatorContext) {
		
		boolean result;
		
		
		if(code!=null) {
			
			/*
			 * Validation logic:-
			 * Test if the HTML form data start with our prefix
			 * so, whatever the logic written under the value and message field will comes
			 * under prefix
			 */
			
			result = code.startsWith(coursePrefix);
		}else {
			
			/*
			 * If nothing entered(null).... just return true
			 */
			
			result = true;
		}
		
		
		return result;
	}

	

}








































