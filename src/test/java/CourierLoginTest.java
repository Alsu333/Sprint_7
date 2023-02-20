import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.metods.Courier;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.example.models.Constants.Constant.BASE_URL;
import static org.hamcrest.Matchers.*;

public class CourierLoginTest {
    @Before
    public void setUp() {
        RestAssured.baseURI = BASE_URL;
    }
    @Test
    @DisplayName("Courier can be created")
    public void CourierLogin(){
        Response response = Courier.login();
        response.then().log().all()
                .assertThat()
                .statusCode(200)
                .and()
                .body("id", notNullValue());
    }
    @Test
    @DisplayName("Error after login without data")
    public void LoginWithoutPassword(){
        Response response = Courier.loginWithoutLogin();
        response.then().log().all()
                .assertThat()
                .statusCode(400)
                .and()
                .body("message",equalTo("Недостаточно данных для входа"));
    }
    @Test
    @DisplayName("Login with notValid data")
    public void LoginNoValidData(){
        Response response = Courier.noRegData();
        response.then().log().all()
                .assertThat()
                .statusCode(404)
                .and()
                .body("message",equalTo("Учетная запись не найдена"));
    }
    @After
    public void setDown() {
        Response response = Courier.delete_client();
        response.then();
    }
}

