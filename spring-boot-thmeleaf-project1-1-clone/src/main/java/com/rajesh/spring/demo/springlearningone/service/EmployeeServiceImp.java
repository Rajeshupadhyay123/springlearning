package com.rajesh.spring.demo.springlearningone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajesh.spring.demo.springlearningone.dao.EmployeeRepository;
import com.rajesh.spring.demo.springlearningone.entity.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImp(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		List<Employee> employeeList = employeeRepository.findAll();
		
		if(employeeList==null) {
			new Throwable("Employee did found in the Database");
		}
		return employeeList;
	}

	@Override
	public void saveEmployee(Employee employee) {
		
		employeeRepository.save(employee);
		
	}

	@Override
	public Employee findById(int id) {
		
		Employee employee= null;
		
		Optional<Employee> employeeCheck = employeeRepository.findById(id);
		
		if(employeeCheck.isPresent()) {
			
			employee = employeeCheck.get();
		}else {
			new Throwable("Employee not found on employee Id "+id);
		}
		return employee;
	}

	@Override
	public void deleteEmployee(int id) {
		
		Optional<Employee> result = employeeRepository.findById(id);
		
		if(result.isPresent()) {
			
			Employee employee = result.get();
			employeeRepository.delete(employee);
		}else {
			
			new Throwable("Didn't find Employee on employee Id "+id);
		}
		
		
		
	}
	
	
	
}
