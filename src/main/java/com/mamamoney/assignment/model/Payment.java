package com.mamamoney.assignment.model;

import java.io.Serializable;

public class Payment implements Serializable {
    private Country country;
    private float randAmount;

    public Payment() {

    }

    public float getRandAmount() {
        return randAmount;
    }

    public void setRandAmount(float randAmount) {
        this.randAmount = randAmount;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
