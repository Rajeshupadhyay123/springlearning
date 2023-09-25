package com.rajesh.spring.demo.springlearningone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	
	//create a mapping for /hello
	
	@GetMapping("/hello")
	public String sayHello(Model theModel) {
		
		theModel.addAttribute("theDat", new java.util.Date());
		
		return "helloword";
	}

}
