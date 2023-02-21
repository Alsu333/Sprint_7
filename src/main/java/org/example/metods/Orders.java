package org.example.metods;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class Orders {

    @Step("Order can be creating")
    public static Response orderCanCreate(Orders orders) {
        return given()
                .header("Content-type", "application/json")
                .body(orders)
                .when()
                .post("api/v1/orders");
    }

    @Step("Get a list of orders")
    public static Response ListOfOrders() {
        return given()
                .header("Content-type", "application/json")
                .get("api/v1/orders");
    }
}
