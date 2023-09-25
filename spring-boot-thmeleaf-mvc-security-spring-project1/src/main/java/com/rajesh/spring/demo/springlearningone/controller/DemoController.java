package com.rajesh.spring.demo.springlearningone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	@GetMapping("/")
	public String showHome() {
		
		
		return "home";
	}
	
	//add a request mapping for /leaders
	
	@GetMapping("/leaders")
	public String showLeader() {
		
		
		return "leaders";
	}
	
	//add a request mapping for /systems
	
		@GetMapping("/systems")
		public String showAdmin() {
			
			
			return "systems";
		}

}
