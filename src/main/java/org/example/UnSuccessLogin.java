package org.example;

public class UnSuccessLogin extends SuccesRegistr {
    private String message;

    public UnSuccessLogin(String message) {
        this.message = message;
    }
    public UnSuccessLogin(){}
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
