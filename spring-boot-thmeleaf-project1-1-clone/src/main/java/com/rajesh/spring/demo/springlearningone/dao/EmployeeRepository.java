package com.rajesh.spring.demo.springlearningone.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rajesh.spring.demo.springlearningone.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
