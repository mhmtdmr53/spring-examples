package com.deneme.SpringAnnotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:PropertiesFile")

//@ComponentScan("com.deneme.SpringAnnotations")
public class SportConfig {

	
	// define bean for our sad fortune service with bean ID
	
	@Bean
	public FortuneService sadFortuneService()
	{
		return new SadFortuneService();
		
	}
	
	// define bean for our swim coach and inject dependency
	@Bean
	public Coach swimCoach()
	{
		return new SwimCoach(sadFortuneService());
		
	}
	
}
