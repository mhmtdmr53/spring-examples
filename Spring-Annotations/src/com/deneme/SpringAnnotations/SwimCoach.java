package com.deneme.SpringAnnotations;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	
	private FortuneService fortuneService;
	
	//@Value("${foo.email}")
	//private String email;
	
	//@Value("${foo.team}")
	//private String team;
	
	/*public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}
*/
	public SwimCoach(FortuneService fortuneService) {
	
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		
		return "100 metre yuzme antremani ";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
