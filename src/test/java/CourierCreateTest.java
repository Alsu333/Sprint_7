import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.metods.Courier;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.example.models.Constants.Constant.BASE_URL;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CourierCreateTest {
    @Before
    public void setUp() {
        RestAssured.baseURI = BASE_URL;
    }

    @Test
    @DisplayName("Courier can be created")
    public void createCourier() {
        Response response = Courier.create();
        response.then().log().all()
                .assertThat()
                .statusCode(201)
                .and()
                .body("ok", is(true));
    }

    @Test
    @DisplayName("Can't create without data")
    public void createCourierwihoitPassword() {
        Courier.create();
        Response response = Courier.courierCreateWithoutPassword();
        response.then().log().all()
                .assertThat()
                .statusCode(400)
                .and()
                .assertThat()
                .body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }

    @Test
    @DisplayName("Don't create the same couriers")
    public void сreateSameCourier() {
        Courier.create();
        Response response = Courier.create();
        response.then().log().all()
                .statusCode(409)
                .and()
                .assertThat()
                .body("message", equalTo("Этот логин уже используется. Попробуйте другой."));
    }

    @After
    public void setDown() {
        Response response = Courier.delete_client();
        response.then();
    }
}
