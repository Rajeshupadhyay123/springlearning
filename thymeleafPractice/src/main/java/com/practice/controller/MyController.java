package com.practice.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

	@GetMapping("/about")
	public String about(Model model) {
		
		
		System.out.println("Inside About Handler");
		
		model.addAttribute("name","Rajesh");
		model.addAttribute("currentDate", new Date());
		return "about";
	}
	
	//handing iteration
	
	@GetMapping("/example-loop")
	public String iterateHandler(Model model) {
		
		List<String> names = List.of("Ankit","Rajesh","Shalu","Lakxmi","John");
		
		model.addAttribute("names", names);
		return "iterate";
	}
	
	
	//handler for conditional statement
	@GetMapping("/condition")
	public String conditionalHelper(Model model) {
		
		List<Integer> list = List.of(1);
		
		model.addAttribute("isActive", true);
		model.addAttribute("gender", "F");
		model.addAttribute("myList", list);
		
		return "condition";
	}
	
	
	//handler for including fragments
	@GetMapping("/service")
	public String servicesHandler(Model model) {
		
		model.addAttribute("title", "I like coding");
		model.addAttribute("subtitle", LocalDate.now().toString());
		
		return "service";
	}
	
	//for new about
	@GetMapping("/newAbout")
	public String newAvout() {
		
		return "about_new";
	}
	
	
	//for content
	@GetMapping("/content")
	public String getContent() {
		
		return "content";
	}
	
}




















