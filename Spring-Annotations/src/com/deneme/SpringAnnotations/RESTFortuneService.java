package com.deneme.SpringAnnotations;

import org.springframework.stereotype.Component;

@Component
public class RESTFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		
		return "Your luck is complicated";
	}

}
