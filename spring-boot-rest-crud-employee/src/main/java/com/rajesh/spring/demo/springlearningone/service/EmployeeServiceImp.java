package com.rajesh.spring.demo.springlearningone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajesh.spring.demo.springlearningone.dao.EmployeeDao;
import com.rajesh.spring.demo.springlearningone.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImp implements EmployeeService {

	private EmployeeDao employeeDao;
	
	
	@Autowired
	public EmployeeServiceImp(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}



	@Override
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}



	@Override
	public Employee findById(int id) {
		
		return employeeDao.findById(id);
	}




	/*
	 * Here we didn't use @Transactional on dao even we are using into Service method
	 * Because it is a best practice
	 */
	@Transactional
	@Override
	public Employee save(Employee employee) {
		return employeeDao.save(employee);
	}




	@Transactional
	@Override
	public void deleteById(int id) {
		employeeDao.deleteById(id);
		
	}

	
}
