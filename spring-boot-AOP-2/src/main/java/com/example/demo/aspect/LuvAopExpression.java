package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
 * If you only have pointcuts then @Aspect is optional.
 * 
 * Only required if you ad advice in this class @Before , @After etc.
 */

@Aspect
@Component
public class LuvAopExpression {

	/*
	 *com.example.demo.dao.*.*(..)  meaning:-
	 *It mean that for the package com.example.demo.dao if any further package will make
	 *then this will be applicable for '*' and for this package, any methods name will be
	 *applicable for second '*'. and for that methods any methods signature will be 
	 *applicable for '(..)' methods body.
	 *
	 *So, for this package any methods will executed then this Pointcut will generate
	 *and call by any adviser which will applicable for this Pointcut
	 */
	@Pointcut("execution(* com.example.demo.dao.*.*(..))")
	 public void forDaoPackakge() {}
	
	
	//create a pointcut for getter methods
	@Pointcut("execution(* com.example.demo.dao.*.get*(..))")
	public void getter() {}
	
	//create a pointcut for setter methods
	@Pointcut("execution(* com.example.demo.dao.*.set*(..))")
	public void setter() {}
	
	//create pointcut: include packkage..... exclude getter/setter
	@Pointcut("forDaoPackakge() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}
	
}
