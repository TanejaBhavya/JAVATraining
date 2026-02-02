package com.app.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.app.util.NameFormatter;

@Service
public class WelcomeService {
	
	private NameFormatter nameFormatter;
	
	@Value("${app.author}")
	private String author;
	
	public WelcomeService(NameFormatter nameFormatter) {
		this.nameFormatter = nameFormatter;
	}
	
	public String greet(String name) {
		String formattedName = nameFormatter.formate(name);
		return "Welcome " + formattedName + " to Spring boot!";
	}
	
	public String getAuthor() {
		return "Application author: " + author;
	}
	
}
