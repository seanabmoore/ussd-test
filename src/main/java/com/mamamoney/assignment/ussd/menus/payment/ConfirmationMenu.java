package com.mamamoney.assignment.ussd.menus.payment;


import com.mamamoney.assignment.CurrencyEngine;
import com.mamamoney.assignment.models.Payment;

public class ConfirmationMenu extends PaymentMenu {
    // TODO replace with Service
    private CurrencyEngine currencyEngine = new CurrencyEngine();

    private static final String menu = "Your person you are sending to, will receive %s %s \n 1) Confirm";

    @Override
    public String getMenu(Payment payment) {
        String currencyCode = payment.getCountry().getCurrencyCode();
        double randAmount = payment.getRandAmount();
        double foreignCurrencyAmount = currencyEngine.get_amount_in_zar(currencyCode, randAmount);
        return String.format(menu, foreignCurrencyAmount, currencyCode);
    }

    @Override
    public void handleUserInput(Payment payment, String userInput) {
        //TODO: Add validation
        switch (userInput) {
            case "1": {
                //TODO Process Payment
            }
            default: {

            }
        }
    }
}
