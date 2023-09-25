package com.rajesh.spring.demo.springlearningone.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajesh.spring.demo.springlearningone.entity.Employee;

//Here Employee is Entity Type and Integer is primary key
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
}
