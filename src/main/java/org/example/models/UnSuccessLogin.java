package org.example.models;

public class UnSuccessLogin {
    private String message;

    public UnSuccessLogin(String message) {
        this.message = message;
    }

    public UnSuccessLogin() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

