package org.example;

public class SuccessLogin{

    private static Integer id;
    //private Integer id;
    public SuccessLogin(Integer id) {
        this.id = id;
    }
    public SuccessLogin() {}

    public static Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
