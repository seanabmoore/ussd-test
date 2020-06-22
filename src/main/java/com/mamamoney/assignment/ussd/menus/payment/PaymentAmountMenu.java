package com.mamamoney.assignment.ussd.menus.payment;

import com.mamamoney.assignment.model.USSDSession;
import com.mamamoney.assignment.model.Payment;
import com.mamamoney.assignment.ussd.journeys.UserInputException;

public class PaymentAmountMenu extends PaymentMenu {

    private static final String menu = "How much money in Rands, would you like to send to %s";

    @Override
    public String getMenu(USSDSession ussdSession) {
        return String.format(menu, ussdSession.getPayment().getCountry().toString());
    }

    @Override
    public void handleUserInput(Payment payment, String userInput) throws UserInputException {
        try {
            payment.setRandAmount(Float.parseFloat(userInput));
        }catch (NumberFormatException nfe){
            throw new UserInputException(nfe.getMessage());
        }

    }
}