package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {

	
	@Before("com.example.demo.aspect.LuvAopExpression.forDaoPackageNoGetterSetter()")
	public void performAnalytics() {
		System.out.println("\n========>> Performing API Analytics");
	}
	
	
}
