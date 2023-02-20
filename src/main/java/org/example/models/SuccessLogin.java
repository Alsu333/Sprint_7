package org.example.models;

public class SuccessLogin {
    private static Integer id;

    //private Integer id;
    public SuccessLogin(Integer id) {
        SuccessLogin.id = id;
    }

    public SuccessLogin() {
    }

    public static Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        SuccessLogin.id = id;
    }
}
