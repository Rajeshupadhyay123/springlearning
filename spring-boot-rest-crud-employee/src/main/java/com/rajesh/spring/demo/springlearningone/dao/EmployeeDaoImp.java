package com.rajesh.spring.demo.springlearningone.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rajesh.spring.demo.springlearningone.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDaoImp implements EmployeeDao {

	// define EntityManager
	private EntityManager entityManager;

	@Autowired
	public EmployeeDaoImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
		return theQuery.getResultList();
	}

	@Override
	public Employee findById(int id) {
		// find Employee
		Employee employee = entityManager.find(Employee.class, id);

		// return employee
		return employee;
	}

	@Override
	public Employee save(Employee employee) {
		
		// save employee
		//if id==0 then insert/save else update
		Employee dbemployee = entityManager.merge(employee);
		
		return dbemployee;
	}

	@Override
	public void deleteById(int id) {
		// find by id employee
		Employee employee = entityManager.find(Employee.class, id);

		entityManager.remove(employee);
	}

}
