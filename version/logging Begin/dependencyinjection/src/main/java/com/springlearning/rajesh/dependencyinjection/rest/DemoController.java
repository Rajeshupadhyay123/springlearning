package com.springlearning.rajesh.dependencyinjection.rest;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	Logger logger= LogManager.getLogger(DemoController.class);
	
	@GetMapping("/health")
	public String getHelth() {
		logger.info("Health working at line : 17");
		return "Everything Well ";
	}
}
