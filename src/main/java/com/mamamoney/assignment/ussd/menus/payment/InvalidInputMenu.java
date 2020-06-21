package com.mamamoney.assignment.ussd.menus.payment;

import com.mamamoney.assignment.model.USSDSession;
import com.mamamoney.assignment.model.Payment;

public class InvalidInputMenu extends PaymentMenu {
    private static final String menu = "Invalid Input \n 1) Try again";

    @Override
    public String getMenu(USSDSession ussdSession) {
        return menu;
    }

    @Override
    public void handleUserInput(Payment payment, String userInput) {

    }
}
