package com.springlearning.rajesh.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


/*
 * With the help of @Primary we tell the spring bean, whenever someone will call the Coach Interface
 * and no definitation provided by @Qualifier then,
 * bedefault it will take the Running implementation
 */

@Component
@Primary
public class Running implements Coach {

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice running for 10k";
	}

}
