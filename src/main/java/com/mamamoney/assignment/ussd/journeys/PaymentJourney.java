package com.mamamoney.assignment.ussd.journeys;


import com.mamamoney.assignment.model.USSDSession;
import com.mamamoney.assignment.model.USSDRequest;
import com.mamamoney.assignment.ussd.menus.payment.*;

// TODO Make prototype pattern

public class PaymentJourney extends Journey {
    private PaymentMenu currentMenu;
    private PaymentMenu invalidInputMenu;
    private PaymentMenu exceptionMenu;
    private PaymentMenu initial;

    public PaymentJourney() {
        PaymentMenu welcomeMenu = new WelcomeMenu();
        PaymentMenu paymentAmount = new PaymentAmountMenu();
        PaymentMenu confirmationMenu = new ConfirmationMenu();
        PaymentMenu paymentEndMenu = new PaymentEndMenu();

        this.invalidInputMenu = new InvalidInputMenu();
        this.exceptionMenu = new ExceptionMenu();

        welcomeMenu.setNext(paymentAmount.getId());
        paymentAmount.setNext(confirmationMenu.getId());
        confirmationMenu.setNext(paymentEndMenu.getId());

        this.addMenus(welcomeMenu);
        this.addMenus(paymentAmount);
        this.addMenus(confirmationMenu);
        this.addMenus(paymentEndMenu);

        this.currentMenu = welcomeMenu;
        this.initial = welcomeMenu;
    }

    public String handleRequest(USSDRequest ussdRequest, USSDSession ussdSession) {
        String menuID = ussdSession.getCurrentScreenID();
        String userEntry = ussdRequest.getUserEntry();
        if (menuID == null) {
            // First Time
            menuID = initial.getId();
            userEntry = null;
        }

        if ( this.invalidInputMenu.getId().equals(menuID)){
            menuID = ussdSession.getPreviousScreenID();
        }

        PaymentMenu currentM = this.getMenu(menuID);
        ussdSession.setCurrentScreenID(currentM.getId());
        try {
            if (userEntry != null && !"".equals(userEntry.trim())) {
                currentM.handleUserInput(ussdSession.getPayment(), ussdRequest.getUserEntry());
                if (currentM.hasNext()) {
                    ussdSession.setCurrentScreenID(currentM.getNext());
                } else {
                    ussdSession.setCurrentScreenID(initial.getId());
                }
            }
            return currentM.getMenu(ussdSession);


        } catch (UserInputException uie) {
            ussdSession.setCurrentScreenID(this.invalidInputMenu.getId());
            ussdSession.setPreviousScreenID(menuID);
            return this.invalidInputMenu.getMenu(ussdSession);
        } catch (Exception ex) {
            ussdSession.setCurrentScreenID(this.initial.getId());

            return this.exceptionMenu.getMenu(ussdSession);
        }
    }
}
