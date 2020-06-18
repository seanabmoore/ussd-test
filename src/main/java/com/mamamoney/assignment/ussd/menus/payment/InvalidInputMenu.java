package com.mamamoney.assignment.ussd.menus.payment;

import com.mamamoney.assignment.models.Payment;

public class InvalidInputMenu extends PaymentMenu {
    private static final String menu = "Invalid Input \n 1) Try again";

    @Override
    public String getMenu(Payment payment) {
        return menu;
    }

    @Override
    public void handleUserInput(Payment payment, String userInput) {

    }
}
