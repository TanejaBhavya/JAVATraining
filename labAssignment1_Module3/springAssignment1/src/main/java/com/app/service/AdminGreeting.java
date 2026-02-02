package com.app.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("adminGreeting")
public class AdminGreeting implements GreetingService{

	@Override
	public String greet(String name) {
		
		return "Hello Admin " + name +", you have full acces. ";
	}
	
}
