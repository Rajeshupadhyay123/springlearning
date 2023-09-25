package com.springlearning.rajesh.dependencyinjection.common;

import org.springframework.stereotype.Component;

@Component
public class Running implements Coach {

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice running for 10k";
	}

}
