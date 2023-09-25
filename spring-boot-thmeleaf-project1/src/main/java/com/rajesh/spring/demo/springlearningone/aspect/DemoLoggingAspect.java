package com.rajesh.spring.demo.springlearningone.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {

	//setup logger
	private Logger logger = Logger.getLogger(getClass().getName());
	
	
	//setup pointcut declaration
	@Pointcut("execution(* com.rajesh.spring.demo.springlearningone.controller.*.*(..))")
	private void forControllerPackage() {}
	
	//do the same for service and dao
	@Pointcut("execution(* com.rajesh.spring.demo.springlearningone.service.*.*(..))")
	private void forServicePackage() {}
	
	
	@Pointcut("execution(* com.rajesh.spring.demo.springlearningone.dao.*.*(..))")
	private void forDaoPackage() {}
	
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	
	//add @Before advice
	@Before("forAppFlow()")
	private void before(JoinPoint joinpoint) {
		
		//display methods we are calling
		String methods = joinpoint.getSignature().toShortString();
		logger.info("============>in @Before : calling methods: "+methods);
		
		
		//display the argument to the methods
		
		
		//get the argument
		Object[] args = joinpoint.getArgs();
		
		//loop through and display argument
		for(Object tempArg : args) {
			logger.info("===============>Argument: "+tempArg);
		}
	}
	
	
	//add for @AfterReturning advice
	/*
	 * Note returning argument name should be same as Object name.
	 * i.e:- returning = "result" and Object result
	 * both name is same
	 */
	@AfterReturning(
			pointcut = "forAppFlow()",
			returning = "result")
	public void afterReturning(JoinPoint joinPoint , Object result) {
		
		//display methods we are returning from
		String methods = joinPoint.getSignature().toShortString();
		logger.info("============>in @@AfterReturning : calling methods: "+methods);
		
		
		//display data returned
		logger.info("===========> results: "+result);
		
	}
	
	
}






































