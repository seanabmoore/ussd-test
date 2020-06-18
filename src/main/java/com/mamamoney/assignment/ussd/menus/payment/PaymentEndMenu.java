package com.mamamoney.assignment.ussd.menus.payment;

import com.mamamoney.assignment.models.Payment;

public class PaymentEndMenu extends PaymentMenu {


    private static final String menu = "Thank you for using MAMA money";

    @Override
    public String getMenu(Payment payment) {
        return menu;
    }

    @Override
    public void handleUserInput(Payment payment, String userInput){
    }

}