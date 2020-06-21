package com.mamamoney.assignment.ussd.menus.payment;

import com.mamamoney.assignment.model.USSDSession;
import com.mamamoney.assignment.model.Payment;

public class PaymentEndMenu extends PaymentMenu {


    private static final String menu = "Thank you for using MAMA money";

    @Override
    public String getMenu(USSDSession ussdSession) {
        return menu;
    }

    @Override
    public void handleUserInput(Payment payment, String userInput){
    }

}