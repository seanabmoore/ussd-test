package com.mamamoney.assignment.ussd.menus.payment;

import com.mamamoney.assignment.models.Payment;
import com.mamamoney.assignment.ussd.journeys.UserInputException;

public class PaymentAmountMenu extends PaymentMenu {

    private static final String menu = "How much money in Rands, would you like to send to %s";

    @Override
    public String getMenu(Payment payment) {
        return String.format(menu, payment.getCountry());
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