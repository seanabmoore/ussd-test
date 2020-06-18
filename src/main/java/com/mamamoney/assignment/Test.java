package com.mamamoney.assignment;

import com.mamamoney.assignment.models.Payment;
import com.mamamoney.assignment.ussd.USSDRequest;
import com.mamamoney.assignment.ussd.journeys.PaymentJourney;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        PaymentJourney myJourney = new PaymentJourney("1234","011899988991");
        USSDRequest request = new USSDRequest();
        Payment payment = new Payment();

        System.out.println("Connection to server sucessfully");

        while(true) {
            System.out.println(myJourney.get_menu());
            String input = userInput.nextLine();
            request.setUserEntry(input);
            myJourney.handleUserInput(request);
        }
    }
}
