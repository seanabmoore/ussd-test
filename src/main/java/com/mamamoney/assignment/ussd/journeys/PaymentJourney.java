package com.mamamoney.assignment.ussd.journeys;


import com.mamamoney.assignment.models.Payment;
import com.mamamoney.assignment.ussd.USSDRequest;
import com.mamamoney.assignment.ussd.menus.payment.*;

import java.io.Serializable;

// TODO Make prototype pattern

public class PaymentJourney implements Serializable {

    private String sessionId;
    private String msisdn;
    private Payment payment;

    private PaymentMenu currentMenu;
    private PaymentMenu invalidInputMenu;
    private PaymentMenu exceptionMenu;
    private PaymentMenu initial;

    public PaymentJourney(String sessionId, String msisdn) {
        this.sessionId = sessionId;
        this.msisdn = msisdn;

        PaymentMenu welcomeMenu = new WelcomeMenu();
        PaymentMenu paymentAmount = new PaymentAmountMenu();
        PaymentMenu confirmationMenu = new ConfirmationMenu();
        PaymentMenu paymentEndMenu = new PaymentEndMenu();

        this.invalidInputMenu = new InvalidInputMenu();
        this.exceptionMenu = new ExceptionMenu();

        welcomeMenu.setNext(paymentAmount);
        paymentAmount.setNext(confirmationMenu);
        confirmationMenu.setNext(paymentEndMenu);

        this.currentMenu = welcomeMenu;
        this.initial = welcomeMenu;
        this.payment = new Payment();
    }

    public String get_menu(){
        try {
            return currentMenu.getMenu(this.payment);
        }catch(Exception ex){
            this.currentMenu = this.exceptionMenu;
            return this.exceptionMenu.getMenu(payment);
        }
    }

    public void handleUserInput(USSDRequest request){
        String userInput = request.getUserEntry();
        try {
            this.currentMenu.handleUserInput(this.payment, userInput);
            if (this.currentMenu.hasNext()){
                this.currentMenu = this.currentMenu.getNext();
            }else{
                this.currentMenu = initial;
            }
        }catch (UserInputException uie){
            this.invalidInputMenu.setNext(this.currentMenu);
            this.currentMenu = this.invalidInputMenu;
        }catch (Exception ex){
            this.currentMenu = this.exceptionMenu;
        }

    }

}
