package org.example;

import java.util.Random;

public class CourierGenerator {
   //public static Courier getDefault(){
   //    return new Courier("mail32","dgd","gd");
   //}
     public static Courier getDefault() { // подборка логина, пароля и имени
        String[] login = new String[]{"gmail11", "yandex111", "mail111"};
        String[] password = new String[]{"hi111", "111", "111"};
        String[] firstName = new String[]{"Masha1", "111", "111"};
        int randomLogin = new Random().nextInt(login.length);
        int randomPassword = new Random().nextInt(password.length);
        int randomFirstName = new Random().nextInt(firstName.length);
        return new Courier( login[randomLogin], password[randomPassword], firstName[randomFirstName]);
    }
    public static Courier getWrongData(){
         return new Courier("3880@gmail.com","","amina");
    }
    public static Courier getTheSameData(){
        return new Courier("ninja","1234","saske");
    }
}
