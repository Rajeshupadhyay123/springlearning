package com.rajesh.spring.demo.springlearningone.root;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	
	@GetMapping("/")
	public String sayHello() {
		return "Hello ALL!";
	}
	
	@GetMapping("/workflow")
	public String work() {
		return "WorkFlow report";
	}
}
