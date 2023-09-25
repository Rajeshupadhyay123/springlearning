package com.springlearning.rajesh.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice fast balling for 15min";
	}
	
	
}


/*
 * While using @Component it create spring bean and make available Coach dependency for injection.
 * So, First create interface and create the method which you want to process and then create the 
 * Component class which implement interface.
 * 
 */
