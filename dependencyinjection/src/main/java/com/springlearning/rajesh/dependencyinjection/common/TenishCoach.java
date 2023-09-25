package com.springlearning.rajesh.dependencyinjection.common;

import org.springframework.stereotype.Component;

import com.springlearning.rajesh.dependencyinjection.log.IAppLogger;
import com.springlearning.rajesh.dependencyinjection.log.LogFactory;
import com.springlearning.rajesh.dependencyinjection.rest.DemoController;

@Component
public class TenishCoach implements Coach {

	// Logger logger1= LogManager.getLogger(DemoController.class);
	private static IAppLogger logger = LogFactory.getLoggerInstance(DemoController.class.getName());

	public TenishCoach() {
		logger.log("In Constructor: " + getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice tenish for 20min";
	}

}
