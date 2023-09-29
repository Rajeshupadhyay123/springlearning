package com.example.demo;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class CustomerController {
	
	
	
	//add an initbinder..... to convert trim input string
	//remove leading and trailing whitespace
	//remove issue for our validation
	/*
	 * so, whenever in the field when we string has space (whitespace) without any data then
	 * it will be remove and field will become null
	 * i.e:- "    " -> null
	 * 
	 * Even, if we enter some data in the field and give some space in the end of field then
	 * that space will remove and only data will present
	 * i.e : "upadhyay    " --> "upadhyay"
	 */
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	
	/*
	 * Model allow us to share the information between controller and 
	 * view page (Thymeleaf)
	 */
	
	@GetMapping("/")
	public String showForm(Model model) {
		
		model.addAttribute("customer", new Customer());
		
		return "/customer-form";
	}
	
	
	/*
	 * @Valid: tell the MVC to  perform validation
	 * 
	 * Here Spring will go for the validation on Customer class and the validation result
	 * will store on the BindingResult.
	 * 
	 * So, in the Customer class we have set the validation on the lastName .
	 */
	
	@PostMapping("/processForm")
	public String processForm(
			@Valid @ModelAttribute("customer") Customer customer,
			BindingResult bindingResult ) {
		
		System.out.println("Last name :| "+customer.getLastName()+"|");
		
		
		System.out.println("Binding Results: "+bindingResult);
		System.out.println("\n\n\n\n");
		
		if(bindingResult.hasErrors()) {
			return "customer-form";
		}else {
			return "customer-confirmation";
		}
		
	}
	
}




























