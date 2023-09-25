package com.rajesh.spring.demo.springlearningone.rest;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
   public static	Logger logger = LogManager.getLogger(FunRestController.class);
			
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World!";
	}
	
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	@GetMapping("/teaminfo")
	public String propertyTest() {
		logger.info("Home method accessased");
		return "Team is : "+teamName + " coach is: "+coachName;
	}
}
