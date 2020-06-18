package com.mamamoney.assignment.cache;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service

public class LocalCache {

    private HashMap<String,Object> cache = new HashMap<>();

    public Object getCachedObject(String sessionID){
        return cache.get(sessionID);
    }

    public Object putCachedObject(String sessionID, Object object){
        return cache.put(sessionID, object);
    }
}
