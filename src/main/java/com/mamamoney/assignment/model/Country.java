package com.mamamoney.assignment.model;

import java.io.Serializable;

public class Country implements Serializable {
    private String id;
    private String name;
    private String currencyCode;

    public Country(String id, String name, String currencyCode) {
        this.id = id;
        this.name = name;
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }


    @Override
    public String toString() {
        return name;
    }
}
