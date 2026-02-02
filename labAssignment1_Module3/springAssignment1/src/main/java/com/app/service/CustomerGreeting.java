package com.app.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("customerGreeting")
public class CustomerGreeting implements GreetingService{

	@Override
	public String greet(String name) {
		return "Welcome " + name + ", please enjoy our services!";
	}
		
}
