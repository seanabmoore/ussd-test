package com.mamamoney.assignment.service;

import com.mamamoney.assignment.model.USSDRequest;
import com.mamamoney.assignment.model.USSDSession;
import org.springframework.stereotype.Service;

@Service
public class USSDSessionCache extends RedisCache {

    public USSDSession getUSSDSesssion(USSDRequest request){
        Object cachedObject = this.getCachedObject(request.getSessionId());
        USSDSession ussdSession = null;
        if (cachedObject != null){
            ussdSession = (USSDSession)cachedObject;
        }else{
            ussdSession = new USSDSession();
        }
        return ussdSession;
    }

    public void saveUSSDSession(USSDRequest request, USSDSession ussdSession){
        this.putCachedObject(request.getSessionId(), ussdSession);
    }
}
