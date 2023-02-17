package org.example;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;

public class CourierClient extends Client{
    private static final String PATH = "api/v1/courier";
    public ValidatableResponse create(Courier courier){ // ручка создания курьера
        return given()
                .spec(getSpec()) // настравивает наш запрос
                .body(courier)
                .when()
                .post(PATH)
                .then();
    }
    public ValidatableResponse login(CourierLogin credentials){ //ручка логирования курьера
        return given()
                .spec(getSpec())
                .body(credentials)
                .when()
                .post("/api/v1/courier/login")
                .then();
    }
    public ValidatableResponse delete(int id){ // ручка удаления курьера
        return given()
                .spec(getSpec())
                .body(id)
                .when()
                .delete("/api/v1/courier/:id")
                .then();
    }
}
