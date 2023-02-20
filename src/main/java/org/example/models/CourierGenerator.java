package org.example.models;

import java.util.Random;

public class CourierGenerator extends Courier{
    public static Courier getDefault() { // подборка логина, пароля и имени
        String[] login = new String[]{"ninja"};
        String[] password = new String[]{"1234"};
        String[] firstName = new String[]{"Masha127",};
        int randomLogin = new Random().nextInt(login.length);
        int randomPassword = new Random().nextInt(password.length);
        int randomFirstName = new Random().nextInt(firstName.length);
        return new Courier(login[randomLogin], password[randomPassword], firstName[randomFirstName]);
    }
    public static Courier getWrongData() {
        return new Courier("388@gmail.com", "", "amina");
    }
    public static Courier getTheData() {
        return new Courier("ninja", "1234", "saske");
    }
    public static Courier noRegData() {
        return new Courier("388005@gmail", "5050", "5050");
    }
}
