package Courier.creater;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.example.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class TheSameCourierTest {
    //private Courier courier;
    private CourierGenerator courierGenerator;
    private CourierLogin courierLogin;
    Courier courierSame = new CourierGenerator().getTheSameData();
    @Test
    @DisplayName("RegistrationSame ")
    @Description("Registration with the same Data")
    public void TheSameRegTest() {
        Specification.installSpecification(Specification.requestSpecificationURL());
        UnSuccessReg reg = given()
                .body(courierSame) // отправляем эти данные в тело
                .when()
                .post( "api/v1/courier")
                .then().log().all()
                .assertThat().statusCode(409)
                .extract().as(UnSuccessReg.class);
        Assert.assertEquals("Этот логин уже используется. Попробуйте другой.", reg.getMessage());
    }
}
