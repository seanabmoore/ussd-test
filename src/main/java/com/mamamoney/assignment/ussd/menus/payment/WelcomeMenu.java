package com.mamamoney.assignment.ussd.menus.payment;

import com.mamamoney.assignment.model.USSDSession;
import com.mamamoney.assignment.model.Country;
import com.mamamoney.assignment.model.Payment;
import com.mamamoney.assignment.ussd.journeys.UserInputException;

public class WelcomeMenu extends PaymentMenu {
    private static final String menu = "Welcome to Mama Money! " +
            "\n Where would you like to send money to today" +
            "\n1) Kenya" +
            "\n2) Malawi";

    public WelcomeMenu() {

    }

    @Override
    public String getMenu(USSDSession ussdSession) {
        return menu;
    }

    @Override
    public void handleUserInput(Payment payment, String userInput) throws UserInputException {
        switch (userInput) {
            case "1": {
                payment.setCountry(new Country("1","Kenya","KWS"));
                break;
            }
            case "2": {
                payment.setCountry(new Country("2","Malawi","MWK"));
                break;
            }
            default: {
                throw new UserInputException("Invalid selection");
            }
        }
    }
}