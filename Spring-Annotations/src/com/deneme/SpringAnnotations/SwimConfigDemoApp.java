package com.deneme.SpringAnnotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwimConfigDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(SportConfig.class);
		
		
		// get the bean from spring container, first character is lower case at bean ID
		
		Coach theCoach= context.getBean("swimCoach", Coach.class);
		// call a method on the bean
		
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		//System.out.println(theCoach.getEmail()+" "+ theCoach.getTeam());
		// close the context

		context.close();
	}

}
