package com.mamamoney.assignment.ussd.journeys;

public class UserInputException extends Exception {
    public UserInputException(String errorMessage) {
        super(errorMessage);
    }
}
