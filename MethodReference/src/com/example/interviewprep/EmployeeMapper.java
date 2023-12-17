package com.example.interviewprep;

public class EmployeeMapper {

//	public static EmployeeDao convert(Employee employee) {
//		EmployeeDao employeeDao = new EmployeeDao();
//		employeeDao.setId(employee.getId());
//		employeeDao.setName(employee.getName());
//		
//		return employeeDao;
//	}
	
	
	public EmployeeDao convert(Employee employee) {
		EmployeeDao employeeDao = new EmployeeDao();
		employeeDao.setId(employee.getId());
		employeeDao.setName(employee.getName());
		
		return employeeDao;
	}
}
