package com.mamamoney.assignment.service;

import com.mamamoney.assignment.model.USSDRequest;
import com.mamamoney.assignment.model.USSDSession;
import com.mamamoney.assignment.ussd.journeys.PaymentJourney;
import org.springframework.stereotype.Service;

@Service
public class JourneyService {
    private PaymentJourney paymentJourney;

    public JourneyService(){
        paymentJourney = new PaymentJourney();

    }

    public String handleRequest(USSDSession ussdSession, USSDRequest ussdRequest){
        return paymentJourney.handleRequest(ussdRequest,ussdSession);
    }
}
