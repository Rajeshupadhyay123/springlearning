package com.springlearning.rajesh.dependencyinjection.rest;




import org.springframework.beans.factory.annotation.Autowired;
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
	
//	@Autowired
//	public DemoController(Coach theCoach) {
//		cricketCoach=theCoach;
//	}
	
	//Setter Injection
	//we can use any method name, spring will not care about method name
	//Less recommended by spring developer
	
	@Autowired
	public void setCoach(Coach theCoach) {
		cricketCoach=theCoach;
	}
	
	
	@GetMapping("/dailyHealth")
	public String getDailyWorkOut() {		
		return "Report message is: "+cricketCoach.getDailyWorkout();
	}
	
	@GetMapping("/health")
	public String getHelth() {
		
		logger.log("Health messaage is comming at line- 22");
		return "Everything Well ";
	}
}
