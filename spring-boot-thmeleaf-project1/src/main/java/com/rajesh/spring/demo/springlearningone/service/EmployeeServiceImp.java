package com.rajesh.spring.demo.springlearningone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajesh.spring.demo.springlearningone.dao.EmployeeRepository;
import com.rajesh.spring.demo.springlearningone.entity.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService{
	
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImp(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAllByOrderByLastName();
	}



	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
		
	}



	@Override
	public Employee findById(int id) {
		 Optional<Employee> empResult = 	employeeRepository.findById(id);
		 
		 Employee employee = null;
		 
		 if(empResult.isPresent()) {
			 employee = empResult.get();
		 }else {
			 throw new RuntimeException("Didn't find Employee on employee Id "+id);
		 }
		 
		 return employee;
	}



	@Override
	public void deleteById(int id) {
		
		Optional<Employee> employee = employeeRepository.findById(id);
		
		if(employee.isPresent()) {
			employeeRepository.deleteById(id);
		}else {
			throw new RuntimeException("Didn't find Employee on employee Id "+id);
		}
		
	}

}
