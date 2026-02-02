package com.app.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.GreetingService;
import com.app.service.WelcomeService;

@RestController
@RequestMapping("/api")

public class WelcomeController {
	private final WelcomeService welcomeService;
	private GreetingService greetingServiceAdmin;
	private GreetingService greetingServiceCustomer;
	
	public WelcomeController(WelcomeService ws, @Qualifier("adminGreeting")GreetingService greetingServiceAdmin, @Qualifier("customerGreeting")GreetingService greetingServiceCustomer) {
		this.welcomeService=ws;
		this.greetingServiceAdmin=greetingServiceAdmin;
		this.greetingServiceCustomer = greetingServiceCustomer;
	}
	
	@GetMapping("/welcome/{name}")
	public String Welcome(@PathVariable String name) {
		return welcomeService.greet(name);		
	}
	
	
	@GetMapping("/welcome/{name}/{role}")
	public String greet(@PathVariable String name, @PathVariable String role) {
			if("admin".equalsIgnoreCase(role)) {
				return greetingServiceAdmin.greet(name);
			}
			else if ("customer".equalsIgnoreCase(role)) {
				return greetingServiceCustomer.greet(name);
			}
			else {
				return "unknown role " + role;
			}
	}
	
	@GetMapping("/author")
	public String getAuthor() {
		return welcomeService.getAuthor();
	}
}
