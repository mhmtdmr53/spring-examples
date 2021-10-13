package com.deneme.SpringAnnotations;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomService implements FortuneService {

	
	// create an array of strings
	private Random rand=new Random();
	private String[] data = {"yu lucky boiiii","Hell yea matee","I m walkiing heree"};
	private int rand_int;
	
	@Override
	public String getFortune() {
		// pick a random string from the array
		rand_int=rand.nextInt(data.length);
		return data[rand_int];
	}

}
