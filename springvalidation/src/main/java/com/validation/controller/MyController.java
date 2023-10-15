package com.validation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.validation.entity.LoginData;

import jakarta.validation.Valid;

@Controller
public class MyController {

	@GetMapping("/form")
	public String openForm(Model model) {
		
		model.addAttribute("loginData", new LoginData());
		return "form";
	}
	
	//handler for processing form
	/*Note:- @Valid is required for validation
	 * Always keep bindingResult before Model 
	 */
	@PostMapping("/process")
	public String processFrm(@Valid @ModelAttribute("loginData") LoginData loginData,
			BindingResult result,
			Model model) {
		
		if(result.hasErrors()) {
			System.out.println(result);
			return "form";
		}
		
		model.addAttribute("loginData", loginData);
		
		System.out.println(loginData);
		
		return "sucess";
	}
}




















