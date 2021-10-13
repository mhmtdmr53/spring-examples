package com.deneme.SpringAnnotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		Coach myCoach=context.getBean("tennisCoach",Coach.class);
		
		Coach alphaCoach=context.getBean("tennisCoach",Coach.class);
				
		
		boolean result=(myCoach == alphaCoach);
		
		System.out.println("\n Same Object: "+result);
		
		System.out.println("\nLocation myCoach: "+ myCoach);
		
		System.out.println("\nLcation alphaCoach: "+ alphaCoach);
		
		context.close();
	}

}
