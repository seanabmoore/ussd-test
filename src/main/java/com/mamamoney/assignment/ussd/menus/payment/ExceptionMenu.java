package com.mamamoney.assignment.ussd.menus.payment;

import com.mamamoney.assignment.model.USSDSession;
import com.mamamoney.assignment.model.Payment;

public class ExceptionMenu extends PaymentMenu {
    private static final String menu = "An exception occurred, please try again later";

    @Override
    public String getMenu(USSDSession ussdSession) {
        return menu;
    }

    @Override
    public void handleUserInput(Payment payment, String userInput) {

    }
}
