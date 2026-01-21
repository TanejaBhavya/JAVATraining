package com.traingday3;

class InvalidCountryException extends Exception {
    public InvalidCountryException() {
        super("User outside India cannot be registered");
    }
    public InvalidCountryException(String message) {
        super(message);
    }
}
