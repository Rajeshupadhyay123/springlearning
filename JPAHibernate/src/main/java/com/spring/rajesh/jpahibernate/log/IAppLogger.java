package com.spring.rajesh.jpahibernate.log;


public interface IAppLogger {
	
	/*
	 * The TRACE Level designates finer-grained
	 * informational events the DEBUG
	 */

	public static final int TRACE=1;
	
	/*
	 * The DEBUG Level designates fine-grained
	 * informational events that are most useful to debug an application
	 */
	
	public static final int DEBUG=2;
	
	/*
	 * The INFO level designates informational
	 * messages the highlight the process of the
	 * application at coarse-grained level
	 */
	
	public static final int INFO=3;
	
	/*
	 * The WARN level designates potentially harmful situations
	 */
	
	public static final int WARN=4;
	
	/*
	 * The ERROR level designates error
	 * events that might still allow the application to continue running
	 */
	
	public static final int ERROR=5;
	
	/*
	 * The FATAL level designates very serve error events that will presumably lead the
	 * application to abort.
	 */
	
	public static final int OFF=6;
	
	public void log(int level, String message);
	
	public void log(int level, String message, Throwable throwable);
	
	public void log(String message);
}
