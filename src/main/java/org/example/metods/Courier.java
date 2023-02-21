package org.example.metods;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.example.models.CourierGenerator;
import org.example.models.CourierLogin;
import org.example.models.SuccessLogin;
import static io.restassured.RestAssured.given;
import static org.example.models.Constants.Constant.*;

public class Courier {
    @Step("Get response for correct data")
    public static Response create() {
        org.example.models.Courier courier = new org.example.models.Courier(LOGIN, PASSWORD, FIRSTNAME); // ручка создания курьера
        return given()
                .header(ContentType, JSON) // настравивает наш запрос
                .body(courier)
                .when()
                .post(ApiCreate);
    }

    @Step("Create account without data")
    public static Response courierCreateWithoutPassword() {
        org.example.models.Courier courier = new org.example.models.Courier(LOGIN, "", FIRSTNAME);
        return given()
                .header(ContentType, JSON)
                .body(courier)
                .when()
                .post(ApiCreate);
    }

    @Step("login with valid data")
    public static Response login() {
        create();
        CourierLogin courier = new CourierLogin(LOGIN, PASSWORD);
        return given()
                .header(ContentType, JSON)
                .body(courier)
                .when()
                .post(ApiLogin);
    }

    @Step("Login without data")
    public static Response loginWithoutLogin() {
        create();
        CourierLogin courier = CourierLogin.from(CourierGenerator.getWrongData());
        return given()
                .header(ContentType, JSON)
                .body(courier)
                .when()
                .post(ApiLogin);
    }

    @Step("Login with NoRegistration Data")
    public static Response noRegData() {
        create();
        CourierLogin courier = CourierLogin.from(CourierGenerator.noRegData());
        return given()
                .header(ContentType, JSON)
                .body(courier)
                .when()
                .post(ApiLogin);
    }

    @Step("Get a delete response with valid data")
    public static Response delete_client() {
        Response response = login();
        SuccessLogin successLogin = response.body().as(SuccessLogin.class);// ручка удаления курьера
        return given()
                .header(ContentType, JSON)
                .delete(ApiDelete + SuccessLogin.getId());
    }
}
