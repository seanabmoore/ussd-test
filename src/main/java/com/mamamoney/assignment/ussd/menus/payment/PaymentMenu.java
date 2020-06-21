package com.mamamoney.assignment.ussd.menus.payment;

import com.mamamoney.assignment.model.USSDSession;
import com.mamamoney.assignment.model.Payment;
import com.mamamoney.assignment.ussd.journeys.UserInputException;

public abstract class PaymentMenu {
    private String next;

    abstract public String getMenu(USSDSession ussdSession);
    abstract public void handleUserInput(Payment payment, String userInput) throws UserInputException;

    public String getId(){
        return this.getClass().getSimpleName();
    }
    public boolean hasNext(){
        return next != null;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
}