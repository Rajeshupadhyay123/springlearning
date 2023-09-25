package com.rajesh.spring.demo.springlearningone.Controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rajesh.spring.demo.springlearningone.dao.EmployeeRepository;
import com.rajesh.spring.demo.springlearningone.entity.Employee;
import com.rajesh.spring.demo.springlearningone.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private Logger logger = LogManager.getLogger(EmployeeController.class);
	
	private EmployeeService employeeService;
	

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/list")
	public String employeeList(Model model) {
		
		List<Employee> employeeList = employeeService.findAll();
		logger.info(employeeList);
		
		model.addAttribute("employees",employeeList);
		
		
		return "list-employees";
	}
	
	
	@GetMapping("/employeeFormForAdd")
	public String employeeFormForAdd(Model model) {
		
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		
		return "employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		
		employeeService.saveEmployee(employee);
		
		
		return "redirect:/employees/list";
	}
	
	@GetMapping("/employeeFormForUpdate")
	public String updateEmployee(@RequestParam("employeeId") int id,Model model) {
		
		Employee employee = employeeService.findById(id);
		model.addAttribute("employee", employee);
		
		return "employee-form";
	}
	
	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("employeeId") int id) {
		
		employeeService.deleteEmployee(id);
		
		return "redirect:/employees/list";
	}

}
