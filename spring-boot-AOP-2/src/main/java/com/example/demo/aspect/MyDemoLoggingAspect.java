package com.example.demo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.demo.dao.Account;

/*
 * If you only have pointcuts then @Aspect is optional.
 * 
 * Only required if you ad advice in this class @Before , @After etc.
 */

/*
 * @Order give the priority to run the Aspect.
 * the Lower number -----> Higher priority
 */

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	// add a new advice for @AfterReturning on the findAccounts methods

	@AfterReturning(pointcut = "execution(* com.example.demo.dao.AccountDao.findAccount(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {

		// print out which methods we are advising on
		String methods = joinPoint.getSignature().toShortString();
		System.out.println("\n===========>Executing @AfterReturning on method: " + methods);

		// print out the resuts of the methods
		System.out.println("\n===========>result is: " + result);

		// let's a post-process the data ............ let's modify it......

		// convert the account name to uppercase
		convertAccountNameToUpperCase(result);
		// print out the resuts of the methods
		System.out.println("\n===========>result is: " + result);
	}

	private void convertAccountNameToUpperCase(List<Account> result) {

		// loop through the account
		for (Account account : result) {

			// get uppercase version of name
			String upperName = account.getName().toUpperCase();

			// update the name on the account
			account.setName(upperName);
		}

	}

	// let's start with @Before advice
	/*
	 * @Before("executopm(public void addAccount())") --> Pointcut expession
	 * 
	 * this code will run before public void addAccount()
	 * 
	 */

//	@Before("execution(public void addAccount())") 
//	@Before("execution(public void addAccount())")
	/*
	 * If we want to specific Aspect then we should give the full name with package
	 * Name
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
//	@Before("execution(* add*(..))")

	@Before("com.example.demo.aspect.LuvAopExpression.forDaoPackageNoGetterSetter()")
	public void beforeAddAccount(JoinPoint joinpoint) {

		System.out.println("\n========>> Execution @Before advice on method");

		/*
		 * We can found the methods signature with the help of Joinpoint
		 */

		// display the methods signature
		MethodSignature methodSignature = (MethodSignature) joinpoint.getSignature();

		System.out.println("Methods: " + methodSignature);

		// display methods argument

		// get args
		Object[] args = joinpoint.getArgs();

		// loop through the argument
		for (Object theargs : args) {

			if (theargs instanceof Account) {

				// downcast and print Account specific stuff
				Account theaccount = (Account) theargs;

				System.out.println("Account name: " + theaccount.getName());
				System.out.println("Account level: " + theaccount.getLevel());
			}
		}
	}

}

/*
 * Parameter pattern wildcards () - >matches a methods with no argument (*)
 * ->matches a method with one argument of any type (..) ->matches a methods
 * with 0 or more arguments of any type
 */
