package com.springlearning.rajesh.dependencyinjection.rest;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springlearning.rajesh.dependencyinjection.common.Coach;
import com.springlearning.rajesh.dependencyinjection.log.IAppLogger;
import com.springlearning.rajesh.dependencyinjection.log.LogFactory;

@RestController
public class DemoController {

	//Logger logger1= LogManager.getLogger(DemoController.class);
	private static IAppLogger logger = LogFactory.getLoggerInstance(DemoController.class.getName());
	
	//define the private field for dependency
	private Coach cricketCoach;
	
	
	//Constructor Injection
	//Recommended by spring developer
	
	/*
	 * When we use the AutoWired, this called the spring bean for dependency. And it auto call the class
	 * which implement their dependency
	 */
	
	/*
	 * Qualifier:-
	 * Here there are multiple implementation classes which implement Coach Interface and define as:-
	 * Cricketcoach, TenishCoach and RunningCoach and so on...
	 * In this case, spring will confuse which one spring bean should be taken for this "Coach".
	 * In this case we should use @Qualifier and provide the name of the implemented class, name starting from small-letter
	 * Qualifier has recommended and it is more specific
	 */
	
	//Here we used the concept of primary, defination is in RunningCoach.java
//	@Autowired
//	public DemoController(@Qualifier("tenishCoach") Coach theCoach) {
//		cricketCoach=theCoach;
//	}
	
	/*
	 * Here we are using the Lazy,
	 * All Beans are lazy.. no beans are created until needed, Including DemoController
	 * Once we access REST endpoint /dailyHealth
	 * Spring will determine dependencies for DemoController..
	 * 
	 * For dependency resolution, Spring create instance of TenishCoach First then create
	 * instance of DemoController and inject the tenishCoach
	 */
	
	@Autowired
	public DemoController(@Qualifier("tenishCoach") Coach theCoach) {
		logger.log("In constructor: "+getClass().getSimpleName());
		cricketCoach=theCoach;
	}
	
	//Setter Injection
	//we can use any method name, spring will not care about method name
	//Less recommended by spring developer
	
//	@Autowired
//	public void setCoach(Coach theCoach) {
//		cricketCoach=theCoach;
//	}
	
	
	
	@GetMapping("/dailyHealth")
	public String getDailyWorkOut() {
		logger.log("Daily Health called at : 65");
		return "Report message is: "+cricketCoach.getDailyWorkout();
	}
	
	@GetMapping("/health")
	public String getHelth() {
		
		logger.log("Health messaage is comming at line- 22");
		return "Everything Well ";
	}
}
