package com.traingday3;

public class InvalidAgeException extends Exception {
		InvalidAgeException(){
			super(" Age must be between 18 and 59 ");
		}
		InvalidAgeException(String message){
			super(message);
		}
}
