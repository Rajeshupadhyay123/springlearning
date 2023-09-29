package com.rajesh.spring.demo.springlearningone.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rajesh.spring.demo.springlearningone.dao.EmployeeRepository;
import com.rajesh.spring.demo.springlearningone.entity.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService {
	
	Logger logger  = LogManager.getLogger(EmployeeServiceImp.class);

	private EmployeeRepository employeeRepository;
	
	
	@Autowired
	public EmployeeServiceImp(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}



	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}



	@Override
	public Employee findById(int id) {
		
		//Optional pattern instead of having to check for null
		Optional<Employee> result = employeeRepository.findById(id);
		
		Employee employee=null;
		
		if(result.isPresent()) {
			employee= result.get();
		}else {
			throw new RuntimeException("Didn't find employee id:-"+id);
		}
		
		return employee;
	}



	/*
	 * Here we didn't use @Transactional on dao even we are using into Service method
	 * Because it is a best practice
	 */
//	@Transactional
	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}




//	@Transactional
	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
		
	}



	@Override
	public List<Employee> getCustomEmployee(String firstName, String lastName) {
		
		List<Employee> emplList = null;
		
		emplList = employeeRepository.findEmployeeByFirstNameAndLastName(firstName, lastName);
		
		return emplList;
	}



	@Override
	public int customUpadte(String firstName, Integer id) {
		
		int count=0;
		
		count = employeeRepository.updateEmployeeById(firstName, id);
		
		return count;
	}

	
}
