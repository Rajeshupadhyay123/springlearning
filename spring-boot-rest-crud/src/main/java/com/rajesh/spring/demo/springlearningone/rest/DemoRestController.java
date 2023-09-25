package com.rajesh.spring.demo.springlearningone.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestController {
	
	Logger logger = LogManager.getLogger(DemoRestController.class);

	//add code for "/hello" endPoint
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World!";
	}
}
