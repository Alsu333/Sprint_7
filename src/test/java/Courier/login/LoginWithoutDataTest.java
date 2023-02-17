import io.qameta.allure.junit4.DisplayName;
import io.restassured.http.ContentType;
import org.example.CourierLogin;
import org.example.Specification;
import org.example.UnSuccessReg;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class LoginWithoutDataTest {
    private CourierLogin courierLogin;
    @Test
    @DisplayName("Log ib without fields data")
    public void WithoutLoginTest(){ // если какого-то поля нет, запрос возвращает ошибку;
        courierLogin = new CourierLogin("","jhji");
        Specification.installSpecification(Specification.requestSpecificationURL());
        UnSuccessReg login = given()
                .body(courierLogin)
                .when()
                .post("api/v1/courier/login")
                .then().log().all()
                .assertThat().statusCode(400)
                .extract().as(UnSuccessReg.class);
        Assert.assertEquals("Недостаточно данных для входа", login.getMessage());
    }
}
