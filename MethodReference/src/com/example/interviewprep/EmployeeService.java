package com.example.interviewprep;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EmployeeService {

	public List<Employee> loadEmployeeFromDB(){
		
		return IntStream.range(1, 10)
				.mapToObj(i-> new Employee(i, "employee"+i))
				.collect(Collectors.toList());
		
	}
	
}
