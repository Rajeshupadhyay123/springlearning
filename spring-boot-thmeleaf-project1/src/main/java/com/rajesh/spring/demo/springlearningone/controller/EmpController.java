package com.rajesh.spring.demo.springlearningone.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.rajesh.spring.demo.springlearningone.entity.Employee;
import com.rajesh.spring.demo.springlearningone.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmpController {
	
	Logger logger  =  LogManager.getLogger(EmpController.class);

	private EmployeeService employeeService;

	@Autowired
	public EmpController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	
	@GetMapping("/emplist")
	public String getList(Model model) {
		
		List<Employee> employees = employeeService.findAll();
		logger.info(employees);
		
		model.addAttribute("employees",employees);
		
		return "employees/list-employees";
	}
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		//create model attribute to bind form data
		Employee theEmployee = new Employee();
		theModel.addAttribute("employee", theEmployee);
		
		return "employees/employee-form";
		
	}
	
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId,Model theModel) {
		
		//get the employee from the server
		Employee theEmployee = employeeService.findById(theId);
		
		//set employee in the model to pre-populate the form
		theModel.addAttribute("employee", theEmployee);
		
		return "employees/employee-form";
	}
	
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		
		/*Here we are not setting id =0 because 
		 if there is not data inside the model then id will be 0 so it will insert the data,
		 and if there will be data then it will update the data into the Model
		*/
		//save the Employee
		employeeService.save(employee);
		
		
		//use a redirect t prevent duplication submission
		return "redirect:/employees/emplist";
	
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int id) {
		
		//delete the employee
		employeeService.deleteById(id);
		
		//redirect the employee to /employees/emplist
		
		return "redirect:/employees/emplist";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
