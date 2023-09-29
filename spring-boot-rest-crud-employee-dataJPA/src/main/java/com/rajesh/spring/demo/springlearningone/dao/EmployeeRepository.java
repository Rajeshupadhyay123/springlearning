package com.rajesh.spring.demo.springlearningone.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rajesh.spring.demo.springlearningone.entity.Employee;

import jakarta.transaction.Transactional;

//Here Employee is Entity Type and Integer is primary key
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	
	/*
	 * This is custom query support on JpaRepository
	 * for more https://www.baeldung.com/spring-data-jpa-query
	 */
	@Query("SELECT e FROM Employee e WHERE e.first_name = :firstName and e.last_name=:lastName")
	List<Employee> findEmployeeByFirstNameAndLastName(
	  @Param("firstName") String firstName, 
	  @Param("lastName") String lastName);
	
	
	/*
	 * While using update or insert we should be use @Modifying and @Transactional annotation
	 */
	@Modifying
	@Transactional
	@Query(value = "update Employee e set e.first_name = :firstName where e.id = :id", 
	  nativeQuery = true)
	int updateEmployeeById(@Param("firstName") String firstName, @Param("id") Integer id);
	
	
	/*
	 * This we can do directly without using query
	 * employeeRepository.save(employee)
	 */
	
	@Modifying
	@Transactional
	@Query(
	  value = 
	    "insert into Users (first_name, last_name, email) values (:first_name, :last_name, :email)",
	  nativeQuery = true)
	void insertEmployee(@Param("first_name") String first_name, @Param("last_name") String last_name, 
	  @Param("email") String email);
}
