package com.spring.rajesh.jpahibernate.log;


public class LogFactory {
	
	/*
	 * This method is responsible for returning the required implementation of IAppLogger
	 * interface for the given class name. This logger object will used for the performing 
	 * all the logging activity for the given class.
	 */

	public static IAppLogger getLoggerInstance(final String className) {
		IAppLogger logger= new AppLog4jLoggerImpl(className);
		return logger;
	}
}
