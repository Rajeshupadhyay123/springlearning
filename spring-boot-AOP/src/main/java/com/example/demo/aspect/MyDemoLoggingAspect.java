package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	//This is were we add all of our related advice for logging
	
	
	//let's start with @Before advice
	/*@Before("executopm(public void addAccount())") --> Pointcut expession
	 * 
	 * this code will run before public void addAccount()
	 * 
	 */
	
//	@Before("execution(public void addAccount())") 
//	@Before("execution(public void addAccount())")
	/*
	 * If we want to specific Aspect then we should give the full name with package Name
	 */
//	@Before("execution(public void com.example.demo.dao.AccountDao.addAccount())")
	/*
	 * If we want any methods that's start with 'add'
	 */
//	@Before("execution(public void add*())")
	
	/*
	 * If we want to match methods with based on Return Type
	 */
//	@Before("execution(void add*())")
	
	/*
	 * If we want to match on any return type
	 */
//	@Before("execution(* add*())")
//	@Before("execution(* add*(com.example.demo.dao.Account))")
//	@Before("execution(* add*(com.example.demo.dao.Account, ..))")
	@Before("execution(* add*(..))")
	public void beforeAddAccount() {
		
		System.out.println("\n========>> Execution @Before advice on method");
	}
	
}


/*
 * Parameter pattern wildcards
 * () - >matches a methods with no argument
 * (*) ->matches a method with one argument of any type
 * (..) ->matches a methods with 0 or more arguments of any type
 */




















