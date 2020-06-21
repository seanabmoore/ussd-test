package com.mamamoney.assignment.ussd.journeys;

import com.mamamoney.assignment.ussd.menus.payment.PaymentMenu;

import java.util.HashMap;

public abstract class Journey {
    private HashMap<String, PaymentMenu> menuHashMap = new HashMap<>();
    public void addMenus(PaymentMenu menu){
        menuHashMap.put(menu.getId(), menu);
    }

    public PaymentMenu getMenu(String id){
        return menuHashMap.get(id);
    }
}
