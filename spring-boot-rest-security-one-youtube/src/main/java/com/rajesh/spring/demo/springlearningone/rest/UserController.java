//https://www.youtube.com/watch?v=pRFQwZVGl18&list=PLciPu9FabM_5eWhd3sW8GKA2Um4qbmrcC&index=1&ab_channel=GenieAshwani

package com.rajesh.spring.demo.springlearningone.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

	@GetMapping("/account")
	public String account() {
		return "Hi Welcome";
	}
	
	@GetMapping("/balance")
	public String balance() {
		return "Your Balance = "+10000;
	}
	
	@GetMapping("/update")
	public String update() {
		return "we have an update for you";
	}
	
	@GetMapping("/main")
	public String mainPage() {
		return "This is main page";
	}
	
	
}

/*
 * When sprig security validate the authentication it shared a cookies and this cookies 
 * always shared with server and next time no need to again authentication
 */