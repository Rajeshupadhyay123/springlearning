package com.springlearning.rajesh.dependencyinjection.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AppLog4jLoggerImpl implements IAppLogger {
	
	private transient final Logger logger;
	
	/*
	 * Constructor to retrive a
	 * Logger object for given class
	 */
	
	public AppLog4jLoggerImpl(String className) {
		logger=LogManager.getLogger(className);
	}
	
	/*
	 * This method is responsible for mapping the application logger level with 
	 * the slf4j logger method.
	 * 
	 * @param level- this is application logger level
	 * @Param message- this is message to be logged
	 */
	
	@Override
	public void log(String message) {
		// TODO Auto-generated method stub
		message=logger.getName()+": "+message;
		log(IAppLogger.DEBUG,message);
	}

	@Override
	public void log(final int level, String message) {
		// TODO Auto-generated method stub
		message=logger.getName()+": "+message;
		switch (level) {
		case 1: logger.debug(message);
		break;
		case 2: {
			//here debug is not working
			logger.info(message);
		}
		break;
		case 3: logger.info(message);
		break;
		case 4: logger.warn(message);
		break;
		case 5: logger.error(message);
		break;
		case 6: logger.fatal(message);
		break;
		default:
			logger.warn("No logger Level Fond");
		}

	}

	@Override
	public void log(int level, String message, Throwable throwable) {
		// TODO Auto-generated method stub
		message=logger.getName()+": "+message;
		switch (level) {
		case 1: logger.debug(message);
		break;
		case 2: logger.debug(message);
		break;
		case 3: logger.info(message);
		break;
		case 4: logger.warn(message);
		break;
		case 5: logger.error(message,throwable);
		break;
		case 6: logger.fatal(message);
		break;
		default:
			logger.warn("No logger Level Fond");
		}
	}

	

}
