package com.deneme.SpringAnnotations;

import org.springframework.stereotype.Component;

@Component
public class DatabaseService implements FortuneService {

	@Override
	public String getFortune() {
		
		return "Database is lucky today";
	}

}
