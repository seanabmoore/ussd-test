package com.mamamoney.assignment.api;

import com.mamamoney.assignment.model.USSDSession;
import com.mamamoney.assignment.model.USSDRequest;
import com.mamamoney.assignment.model.USSDResponse;
import com.mamamoney.assignment.service.JourneyService;
import com.mamamoney.assignment.service.USSDSessionCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class USSDController {
    @Autowired private USSDSessionCache ussdSessionCache;
    @Autowired private JourneyService journeyService;

    @PostMapping(path="/ussd")
    public @ResponseBody
    USSDResponse processRequest(@RequestBody USSDRequest request) {
        USSDSession ussdSession = this.ussdSessionCache.getUSSDSesssion(request);
        String message = this.journeyService.handleRequest(ussdSession, request);
        this.ussdSessionCache.saveUSSDSession(request, ussdSession);
        return new USSDResponse(request.getSessionId(),request.getMsisdn(), message);
    }


}