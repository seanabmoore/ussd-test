package com.mamamoney.assignment.ussd.menus.payment;


import com.mamamoney.assignment.service.CurrencyEngine;
import com.mamamoney.assignment.model.USSDSession;
import com.mamamoney.assignment.model.Payment;
import com.mamamoney.assignment.ussd.journeys.UserInputException;

public class ConfirmationMenu extends PaymentMenu {

    private static final String menu = "Your person you are sending to, will receive %s %s \n 1) Confirm";

    @Override
    public String getMenu(USSDSession ussdSession) {
        String currencyCode = ussdSession.getPayment().getCountry().getCurrencyCode();
        double randAmount = ussdSession.getPayment().getRandAmount();
        double foreignCurrencyAmount = CurrencyEngine.getInstance().get_amount_in_zar(currencyCode, randAmount);
        return String.format(menu, foreignCurrencyAmount, currencyCode);
    }

    @Override
    public void handleUserInput(Payment payment, String userInput) throws UserInputException {
        switch (userInput) {
            case "1": {
                //TODO execute Payment
                System.out.println("Pay customer");
                break;
            }
            default: {
                throw new UserInputException("Invalid input");
            }
        }
    }
}
