package com.spring.demo.mvc;

import java.util.LinkedHashMap;

public class Student {

	private String firstName;
	private String lastName;
	private String country;
	private String language;
	private String[] hobies;
	
	private LinkedHashMap<String,String> countryOptions;
	public Student()
	{
		// populate country options: used ISO country code
		countryOptions= new LinkedHashMap<>();
		
		countryOptions.put("BR", "Brazil");
		countryOptions.put("TR", "Turkey");
		countryOptions.put("FR", "France");
		countryOptions.put("GER", "Germany");
		
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	
	public String[] getHobies() {
		return hobies;
	}

	public void setHobies(String[] hobies) {
		this.hobies = hobies;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setCountryOptions(LinkedHashMap<String, String> countryOptions) {
		this.countryOptions = countryOptions;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
