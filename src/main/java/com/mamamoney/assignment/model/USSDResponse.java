package com.mamamoney.assignment.model;

public class USSDResponse {
    private String sessionId;
    private String msisdn;
    private String message;


    public USSDResponse(String sessionId, String msisdn, String message) {
        this.sessionId = sessionId;
        this.msisdn = msisdn;
        this.message = message;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "USSDResponse{" +
                "sessionId='" + sessionId + '\'' +
                ", msisdn='" + msisdn + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}