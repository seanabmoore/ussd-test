package com.mamamoney.assignment.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;

public class CurrencyEngine {
    // This should be stored in DB, but in the interest of time, I am just using this
    // Singleton class

    private static CurrencyEngine instance;
    private HashMap<String, Double> currencies = new HashMap<>();

    public CurrencyEngine(){
        this.currencies.put("ZAR-KWS", 6.10);
        this.currencies.put("ZAR-MWK", 42.50);
    }

    public double get_amount_in_zar(String currencyCode, double amount){
        double conversion = currencies.get("ZAR-"+currencyCode.toUpperCase());
        return conversion * amount;
    }

    public static CurrencyEngine getInstance()
    {
        if (instance == null)
            instance = new CurrencyEngine();

        return instance;
    }

}
