package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;

import jakarta.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	Logger logger  =  LogManager.getLogger(EmployeeController.class);
	
private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeServices) {
		if(employeeService!= null) {
			employeeService = employeeServices;
		}else {
			logger.info("Employeeservice is null "+employeeService);
		}
		
	}

	//get the data from database
	List<Employee> employeeList = employeeService.findAll();

	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		// add to the spring model
		theModel.addAttribute("employees", employeeList);

		return "list-employees";
	}
}









