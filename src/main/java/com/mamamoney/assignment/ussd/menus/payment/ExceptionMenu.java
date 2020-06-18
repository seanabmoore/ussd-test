package com.mamamoney.assignment.ussd.menus.payment;

import com.mamamoney.assignment.models.Payment;

public class ExceptionMenu extends PaymentMenu {
    private static final String menu = "An exception occurred, please try again later";

    @Override
    public String getMenu(Payment payment) {
        return menu;
    }

    @Override
    public void handleUserInput(Payment payment, String userInput) {

    }
}
