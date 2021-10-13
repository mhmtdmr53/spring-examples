package com.deneme.SpringAnnotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		// read spring config file
		
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get the bean from spring container
		
		// first character is lower case at bean ID
		
		Coach theCoach= context.getBean("tennisCoach", Coach.class);
		// call a method on the bean
		
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		// close the context

		context.close();
	}

}
