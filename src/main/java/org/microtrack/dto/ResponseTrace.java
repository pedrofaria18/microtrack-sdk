package org.microtrack.dto;


public class ResponseTrace {

    private int statusCode;

    private String message;

    public ResponseTrace() {}

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
