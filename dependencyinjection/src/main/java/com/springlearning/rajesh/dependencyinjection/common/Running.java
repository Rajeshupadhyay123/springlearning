package com.springlearning.rajesh.dependencyinjection.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.springlearning.rajesh.dependencyinjection.log.IAppLogger;
import com.springlearning.rajesh.dependencyinjection.log.LogFactory;
import com.springlearning.rajesh.dependencyinjection.rest.DemoController;


/*
 * With the help of @Primary we tell the spring bean, whenever someone will call the Coach Interface
 * and no definitation provided by @Qualifier then,
 * bedefault it will take the Running implementation
 * Note:-
 * We cannot use multiple @Primary
 * 
 * Note: Qualifier has higher priority
 */

@Component
//@Primary
public class Running implements Coach {
	

	//Logger logger1= LogManager.getLogger(DemoController.class);
		private static IAppLogger logger = LogFactory.getLoggerInstance(DemoController.class.getName());
	
	public Running() {
		logger.log("In Constructor: "+getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice running for 10k";
	}

}
