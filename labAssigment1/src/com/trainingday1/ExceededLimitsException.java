package com.trainingday1;

public class ExceededLimitsException extends Exception {

	public ExceededLimitsException() {
		super("The input is out of bounds");
	}
	public ExceededLimitsException(String message) {
		super(message);
	}

}
