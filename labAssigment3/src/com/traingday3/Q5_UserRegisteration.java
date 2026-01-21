package com.traingday3;

class Custom{
	public static void registerUser(String username, String userCountry) throws InvalidCountryException {
		if(!userCountry.equalsIgnoreCase("India")) {
			throw new InvalidCountryException("User with username : " + username + " is not from India and can't be registered");
		}
		System.out.println("user registered!");
	}
}

public class Q5_UserRegisteration {
	public static void main(String[] args) {
		try {
			Custom.registerUser("Ram", "India");
			Custom.registerUser("Sam", "England");
		} catch (InvalidCountryException e) {
				System.out.println(e.getMessage());
		}
		
	}
}
