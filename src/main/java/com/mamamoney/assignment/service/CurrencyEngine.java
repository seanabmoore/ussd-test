package com.mamamoney.assignment.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CurrencyEngine {
    private HashMap<String, Double> currencies = new HashMap<>();


    public double get_amount_in_zar(String currencyCode, double amount){
        this.currencies.put("ZAR-KWS", 6.10);
        this.currencies.put("ZAR-MWK", 42.50);
        double conversion = currencies.get("ZAR-"+currencyCode.toUpperCase());
        return conversion * amount;
    }

}
