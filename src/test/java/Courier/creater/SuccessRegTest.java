package Courier.creater;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.example.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class SuccessRegTest {
    private CourierGenerator courierGenerator;
    private Courier courier;
    private CourierLogin courierLogin;
    private DeleteCourier deleteCourier;
    private SuccessLogin successLogin;
    private Integer id = 156174;

    @Test
    @DisplayName("Registration")
    @Description("Registration with Valid Random Data")
    public void SuccessRegTest() {
        Specification.installSpecification(Specification.requestSpecificationURL());// успешный запрос
        Boolean ok = true; // тело ожидаемого ответа
        courier = CourierGenerator.getDefault(); // здесь храняться данные для успешной регистрации
         ValidatableResponse successReg = given()
                .body(courier) // отправляем эти данные в тело
                .when()
                .post( "api/v1/courier")
                .then().log().all()
                .statusCode(200);
        //Assert.assertNotNull(successReg.statusCode(200));
        Assert.assertEquals(ok, successReg.extract().path("ok"));
    }
    @Test
    @DisplayName("Log in")
    @Description("Log in with Valid Random Data")
    public void loginTest(){
        Specification.installSpecification(Specification.requestSpecificationURL());
        courierLogin = CourierLogin.from(CourierGenerator.getDefault());
        ValidatableResponse successLogin = given()
                .body(courierLogin)
                .when()
                .post("api/v1/courier/login")
                .then().log().all()
        .extract().path("id");
        Assert.assertNotNull(SuccessLogin.getId());
    }
    @After
    public void cleanUp(){
        Specification.installSpecification(Specification.requestSpecificationURL());
        //Integer id = successLogin.getId();
        ValidatableResponse deleteCourier = given()
                .body(156174)
                .when()
                .delete("api/v1/courier/:id")
                .then().log().all()
                .statusCode(400).log().all();
    }
}
