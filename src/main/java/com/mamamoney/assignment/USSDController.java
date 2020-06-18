package com.mamamoney.assignment;

import com.mamamoney.assignment.cache.LocalCache;
import com.mamamoney.assignment.ussd.USSDRequest;
import com.mamamoney.assignment.ussd.USSDResponse;
import com.mamamoney.assignment.ussd.journeys.PaymentJourney;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class USSDController {
    @Autowired
    private LocalCache localCache;

    @PostMapping(path="/ussd")
    public @ResponseBody
    USSDResponse processRequest(@RequestBody USSDRequest request) {

        PaymentJourney paymentJourney = this.get_journey(request);
        String message = "";
        if (request.getUserEntry() != null && !"".equals(request.getUserEntry().trim())) {
            paymentJourney.handleUserInput(request);
        }
        message = paymentJourney.get_menu();

        localCache.putCachedObject(request.getSessionId(), paymentJourney);

        return new USSDResponse(request.getSessionId(),request.getMsisdn(), message);
    }

    private PaymentJourney get_journey(USSDRequest request){
        Object cachedObject = localCache.getCachedObject(request.getSessionId());
        PaymentJourney paymentJourney = null;
        System.out.println(cachedObject);
        if (cachedObject != null){
            paymentJourney = (PaymentJourney)cachedObject;
        }else{
            paymentJourney = new PaymentJourney(request.getSessionId(), request.getMsisdn());
        }
        return paymentJourney;
    }
}