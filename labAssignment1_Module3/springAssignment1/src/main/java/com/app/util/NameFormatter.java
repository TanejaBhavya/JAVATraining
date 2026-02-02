package com.app.util;

import org.springframework.stereotype.Component;

@Component 
public class NameFormatter {
	public String formate(String name) {
		return name.trim().toUpperCase();
	}
}
