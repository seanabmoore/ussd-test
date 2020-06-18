package com.mamamoney.assignment.models;

public class Country {
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
}
