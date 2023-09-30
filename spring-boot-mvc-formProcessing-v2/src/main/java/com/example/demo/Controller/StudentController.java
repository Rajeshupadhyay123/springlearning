package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.*;

@Controller
public class StudentController {
	
	//@Value take the data define inside the properties file
	
	@Value("${countries}")
	private List<String> countries;

	@Value("${languages}")
	private List<String> languages;
	
	@Value("${systems}")
	private List<String> systems;

	@GetMapping("/showform")
	public String getFormdata(Model model) {
		
		Student student = new Student();
		
		System.out.println("FirstName is: "+student.getFirstName());
		
		model.addAttribute("student", student);
		
		model.addAttribute("countries", countries);
		
		model.addAttribute("languages", languages);
		
		model.addAttribute("systems", systems);
		
		
		return "student_form";
		
	}
	
	@PostMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student student, Model model) {
		
		
		return "detail_page";
		
	}
	
}
