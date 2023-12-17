package com.example.interviewprep;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MethodsReference {

	public static void  main(String[] args) {
		
		//sSystem.out.println("Rajesh");
		
		
		//using lambda
		EmployeeManager manager = ()-> new Employee();
		String employeeInfo = manager.getEmployee().getEmployeeInfo();
		System.out.println(employeeInfo);
		
		System.out.println("================================");
		
		//using method reference
		EmployeeManager manager2 = Employee::new;
		String employeeInfo2 = manager2.getEmployee().getEmployeeInfo();
		System.out.println(employeeInfo2);
		
		
		System.out.println("=============================");
		
		EmployeeService service = new EmployeeService();
		
//		service.loadEmployeeFromDB()
//		.stream()
//		.forEach(new Consumer<Employee>() {
//
//			@Override
//			public void accept(Employee employee) {
//				System.out.println(employee);
//				
//			}
//		});
		
		
		//using lembda
//		service.loadEmployeeFromDB()
//		.forEach(employee -> System.out.println(employee));
//		
		
		//using methods refernce className::static methods
//		service.loadEmployeeFromDB()
//		.forEach(MethodsReference::print);
		
		
		//out is static methods of PrintStream class 
//		service.loadEmployeeFromDB()
//		.forEach(System.out::println);
		
		
		//convert list of one type to list of another type
		//using normal approche
//		List<EmployeeDao> employeeDao = service.loadEmployeeFromDB()
//		.stream()
//		.map(new Function<Employee, EmployeeDao>() {
//
//			@Override
//			public EmployeeDao apply(Employee employee) {
//				EmployeeDao employeeDao = new EmployeeDao();
//				employeeDao.setId(employee.getId());
//				employeeDao.setName(employee.getName());
//				return employeeDao;
//			}
//			
//		}).collect(Collectors.toList());
		
		
		//using leambda expression
//		List<EmployeeDao> employeeDaoList = service.loadEmployeeFromDB()
//		.stream()
//		.map(employee ->{
//			EmployeeDao employeeDao = new EmployeeDao();
//			employeeDao.setId(employee.getId());
//			employeeDao.setName(employee.getName());
//			return employeeDao;
//		}).collect(Collectors.toList());
		
		
		//using Methods Reference className::staticMethods
//		List<EmployeeDao> employeeDaoList = service.loadEmployeeFromDB()
//		.stream()
//		.map(EmployeeMapper::convert).collect(Collectors.toList());
		
		
		
		//using instance methods objectOfClass::instanceMethodName
		EmployeeMapper mapper = new EmployeeMapper();
		List<EmployeeDao> employeeDaoList = service.loadEmployeeFromDB()
		.stream()
		.map(mapper::convert).collect(Collectors.toList());
		
		System.out.println(employeeDaoList);
		
		
		System.out.println("=======================");
		
		//get the list of Employee Name from list of Employee
		//using lambda
		List<String> listOfName = service.loadEmployeeFromDB()
		.stream()
		.map(employee -> employee.getName()).collect(Collectors.toList());
		
		System.out.println(listOfName);
		
		//using Methods Reference
		System.out.println("===============================");
		List<String> listOfName2 = service.loadEmployeeFromDB()
		.stream()
		.map(Employee::getName).collect(Collectors.toList());
		
		System.out.println(listOfName2);
		/*
		 * Here question can asked getName() is not a static methods
		 * how can we call this as a static methods.....?
		 * 
		 * Ans:-
		 * If a methods don't take any argument then we can consider
		 * that methods as a static call
		 */
		
		
	}
	

	public static void print(Employee employee) {
		System.out.println(employee);
	}
}


















