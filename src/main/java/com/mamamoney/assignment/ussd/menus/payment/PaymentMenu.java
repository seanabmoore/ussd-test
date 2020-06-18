package com.mamamoney.assignment.ussd.menus.payment;

import com.mamamoney.assignment.models.Payment;
import com.mamamoney.assignment.ussd.journeys.UserInputException;

public abstract class PaymentMenu {
    private PaymentMenu next;
    abstract public String getMenu(Payment payment);
    abstract public void handleUserInput(Payment payment, String userInput) throws UserInputException;

    public boolean hasNext(){
        return next != null;
    }

    public PaymentMenu getNext() {
        return next;
    }

    public void setNext(PaymentMenu next) {
        this.next = next;
    }
}