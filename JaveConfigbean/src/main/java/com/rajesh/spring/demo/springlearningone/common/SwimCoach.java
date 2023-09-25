package com.rajesh.spring.demo.springlearningone.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SwimCoach implements Coach {
	
	Logger logger = LogManager.getLogger(SwimCoach.class);
	
	public SwimCoach() {
		logger.info("In Constructor: "+getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "return 100m from worm up";
	}

}
