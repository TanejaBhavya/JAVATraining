package com.trainingday2;

public class NegativeInputException extends Exception {
		public NegativeInputException() {
			super("The input can't be negative");
			
		}
		public NegativeInputException(String message) {
			super(message);
		}
}
