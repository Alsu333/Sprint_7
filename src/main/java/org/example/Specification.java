package org.example;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specification {
    private final static String URL = "https://qa-scooter.praktikum-services.ru/";
    public static RequestSpecification requestSpecificationURL() {
        return new RequestSpecBuilder()
                .setBaseUri(URL)
                .setContentType(ContentType.JSON)
                .build();
    }
    public static void installSpecification(RequestSpecification request){
        RestAssured.requestSpecification = request;
    }
}
