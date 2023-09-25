package com.springlearning.rajesh.dependencyinjection.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.springlearning.rajesh.dependencyinjection.log.IAppLogger;
import com.springlearning.rajesh.dependencyinjection.log.LogFactory;
import com.springlearning.rajesh.dependencyinjection.rest.DemoController;


/*
 * @Lazy
 * When we simple use the @Component then spring bean create the instance for the class without it is actual needed,
 * But when we use the @Lazy then this component will only initialzed when need or we call by explicitly
 * It is very deficult to use the @Lazy for all the class if the project is huge, so in that case use the lazy on the 
 * global configuration in application.property
 */

@Component
@Lazy
public class CricketCoach implements Coach {
	
	//Logger logger1= LogManager.getLogger(DemoController.class);
		private static IAppLogger logger = LogFactory.getLoggerInstance(DemoController.class.getName());
	
	public CricketCoach() {
		logger.log("In Constructor: "+getClass().getSimpleName());
	}

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
