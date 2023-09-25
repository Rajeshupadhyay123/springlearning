package com.springlearning.rajesh.common;

import org.springframework.stereotype.Component;

@Component

public class TenishCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice tenish for 20min";
	}

}
