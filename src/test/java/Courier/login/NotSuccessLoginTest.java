package Courier.login;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.http.ContentType;
import org.example.CourierLogin;
import org.example.Specification;
import org.example.SuccessLogin;
import org.example.UnSuccessReg;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class NotSuccessLoginTest {
    private CourierLogin courierLogin;
    @Test
    @DisplayName("Log in with wrong data Test")
    public void NotSuccessLoginTest(){ // запрос с несуществующей парой пароль-логин в системе
        Specification.installSpecification(Specification.requestSpecificationURL());
        courierLogin = new CourierLogin("ninj","jhji");
        UnSuccessReg login = given()
                .body(courierLogin)
                .when()
                .post("api/v1/courier/login")
                .then().log().all()
                .assertThat().statusCode(404)
                .extract().as(UnSuccessReg.class);
        Assert.assertEquals("Учетная запись не найдена", login.getMessage());
    }
}
