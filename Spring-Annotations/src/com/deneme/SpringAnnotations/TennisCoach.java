package com.deneme.SpringAnnotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class TennisCoach implements Coach {

	
	@Autowired
	@Qualifier("randomService")
	private FortuneService fortuneService;
	
	/*
	@Autowired
	public TennisCoach(FortuneService fortuneService) {
		
		this.fortuneService = fortuneService;
	}
	*/
	// define a default constructor
	public TennisCoach()
	{
		System.out.println("inside a constructor");
	}
	
	// define a setter method
	
	/*@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

*/
	
	// define my init method that use for after constructor
	
	@PostConstruct
	public void doSomething()
	{
		System.out.println("in the inint method ");
	}
	
	
	
	// define my destroyed method that use for before the bean destroyed

	@PreDestroy
	public void doSomethingBeforeEnding()
	{
		System.out.println("this bean is ending ");
	}
	
	
	@Override
	public String getDailyFortune()
	{
		return fortuneService.getFortune();
		
	}

	@Override
	public String getDailyWorkout() {
		
		return "15 dakika kardiyo";
	}

}
