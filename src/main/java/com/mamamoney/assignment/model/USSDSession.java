package com.mamamoney.assignment.model;

import java.io.Serializable;

public class USSDSession implements Serializable {
    public USSDSession(){
        this.payment = new Payment();
    }
    public Payment getPayment() {
        return payment;
    }

    private Payment payment;
    private String currentScreenID;
    private String previousScreenID;

    public String getCurrentScreenID() {
        return currentScreenID;
    }

    public void setCurrentScreenID(String currentScreenID) {
        this.currentScreenID = currentScreenID;
    }

    public String getPreviousScreenID() {
        return previousScreenID;
    }

    public void setPreviousScreenID(String previousScreenID) {
        this.previousScreenID = previousScreenID;
    }
}
