package Courier.creater;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.lang.reflect.Type;
import static io.restassured.RestAssured.given;

public class CourierTestWithoutData {
    private Courier courier;
    private CourierGenerator courierGenerator;
    Courier courierWrong = new CourierGenerator().getWrongData();// здесь храняться данные для регистрации
    @Test
    @DisplayName("RegistrationWrong")
    @Description("Registration with NotValid Data")
    public void NoSuccessRegTest() {
        Specification.installSpecification(Specification.requestSpecificationURL());
        UnSuccessReg notSuccessReg = given()
                .body(courierWrong) // отправляем эти данные в тело
                .when()
                .post( "api/v1/courier")
                .then().log().all()
                .assertThat().statusCode(400)
                .extract().as(UnSuccessReg.class);
        Assert.assertEquals("Недостаточно данных для создания учетной записи", notSuccessReg.getMessage());
    }
    @Test
    @DisplayName("Log in")
    @Description("Log in with Wrong or the")
    public void TheSameRegTest() { // если создать пользователя с логином, который уже есть, возвращается ошибка
        Specification.installSpecification(Specification.requestSpecificationURL());
        courier = new Courier("ninja","1234","saske"); // здесь храняться данные для регистрации
        UnSuccessReg Reg = given()
                .body(courier) // отправляем эти данные в тело
                .when()
                .post( "api/v1/courier")
                .then().log().all()
                .assertThat().statusCode(409)
                .extract().as(UnSuccessReg.class);
        Assert.assertEquals("Этот логин уже используется", Reg.getMessage());
    }
}
