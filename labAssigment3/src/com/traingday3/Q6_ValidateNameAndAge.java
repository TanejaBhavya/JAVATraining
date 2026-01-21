package com.traingday3;

public class Q6_ValidateNameAndAge {
	public static void main(String[] args) {
		try {
			if(args.length <2) {
				System.out.println("Please enter name and age");
				return;
			}
			String name = args[0];
			int age = Integer.parseInt(args[1]);
			if(age< 18 || age >60) {
				throw new InvalidAgeException();
			}
			else {
				System.out.println("name: " + name + " Age: " +age);
			}
		}
		catch(InvalidAgeException e) {
			System.out.println(e.getMessage());
		}
		catch (NumberFormatException e) {
            System.out.println("Age must be a number");
        }
	}
}
