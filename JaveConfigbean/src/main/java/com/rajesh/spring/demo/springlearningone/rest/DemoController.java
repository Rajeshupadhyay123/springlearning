package com.rajesh.spring.demo.springlearningone.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajesh.spring.demo.springlearningone.common.Coach;
import com.rajesh.spring.demo.springlearningone.log.IAppLogger;
import com.rajesh.spring.demo.springlearningone.log.LogFactory;

@RestController
public class DemoController {
	
	IAppLogger logger = LogFactory.getLoggerInstance(DemoController.class.getName());

	private Coach myCoach;

	@Autowired
	public DemoController(@Qualifier("aquartic") Coach myCoach) {
		this.myCoach = myCoach;
		
		logger.log("In constructor: "+getClass().getSimpleName());
	}
	
	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		logger. log("Constructor injection called");
		return myCoach.getDailyWorkout();
	}
	
	
	
}
