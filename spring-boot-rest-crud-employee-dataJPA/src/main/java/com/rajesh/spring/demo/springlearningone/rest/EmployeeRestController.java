package com.rajesh.spring.demo.springlearningone.rest;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.rajesh.spring.demo.springlearningone.dao.EmployeeRepository;
import com.rajesh.spring.demo.springlearningone.entity.Employee;
import com.rajesh.spring.demo.springlearningone.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	Logger logger  =  LogManager.getLogger(EmployeeRepository.class);
	
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
//	@GetMapping("/employees")
//	public List<Employee> findAll(){
//		return employeeService.findAll();
//	}
	
	//Adding mapping for GET /employee/{employeeId}
	@GetMapping("/employee/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee employee = employeeService.findById(employeeId);
		
		if(employee==null) {
			throw new RuntimeException("Employee id not found---"+employeeId);
		}
		
		return employee;
	}
	
	//Adding mapping for POST /employees --add new employee
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		
		//also just in case they pass an id in JSON ...set id to 0
		//this is to force server of new item... instead of update
		//if id==0 then insert/save else update
		employee.setId(0);
		Employee dbEmployee = employeeService.save(employee);
		
		return dbEmployee;
	}
	
	//Adding mapping for PUT /employee
//	@PutMapping("/employee")
//	public Employee updateEmployee(@RequestBody Employee employee) {
//		Employee dbEmployee = employeeService.save(employee);
//		
//		return dbEmployee;
//	}
	
	
	//Adding mapping for DELETE /employee/{employeeId}
	@DeleteMapping("/employee/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		Employee employee = employeeService.findById(employeeId);
		
		//throw exception if null
		if(employee ==null) {
			throw new RuntimeException("Employee is not found  "+employeeId);
		}
		
		employeeService.deleteById(employeeId);
		
		return "Deleted Employee Id ---"+employeeId;
	}
	
	
	//how to call http://localhost:8080/api/employees?firstName=Rajesh&lastName=upadhyay
	@GetMapping("/employees")
	public List<Employee> getCustomEmployee(
			@RequestParam(defaultValue = "Rajesh") String firstName, 
			@RequestParam(defaultValue = "upadhyay") String lastName){
		
		
				
		List<Employee> emplList=null;
//		
//		    emplList=  employeeRepository.findEmployeeByFirstNameAndLastName(firstName, lastName);
		
		emplList = employeeService.getCustomEmployee(firstName, lastName);
		
		if(emplList!=null) {
			return emplList;
		}else {
			return null;
		}
	}
	
	/*
	 * Always remember that the path-variable name must be same as method variable name otherwise
	 * it will not be accesible
	 */
	@RequestMapping(value = "/employee/{employeeId}", method = RequestMethod.PUT)
	public Employee customUpdate(@PathVariable int employeeId, @RequestBody String firstName) {
		
		int count=0;
		
		count=employeeService.customUpadte(firstName, employeeId);
		
		if(count>0) {
			Employee employee = employeeService.findById(employeeId);
			return employee;
		}else {
			
			return null;
		}
	}
}
