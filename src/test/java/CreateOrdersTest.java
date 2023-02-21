import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.example.models.OrdersData;
import org.example.models.TrackOrder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.example.models.Constants.Constant.ApiOrders;
import static org.example.models.Constants.Constant.BASE_URL;

@RunWith(Parameterized.class)
public class CreateOrdersTest { //тестовый класс с полями
    private final List<String> colors;
    private OrdersData ordersData;

    public CreateOrdersTest(List<String> colors) {
        this.colors = colors;
    }

    @Parameterized.Parameters
    public static Object[] setOrderColor() {
        return new Object[][]{
                {List.of()},
                {List.of("BLACK")},
                {List.of("GRAY")},
                {List.of("GRAY", "BLACK")}// передали тестовые данные
        };
    }

    @Before
    public void setUp() {
        RestAssured.baseURI = BASE_URL;
    }

    @Test
    @DisplayName("Can choose color in params")
    public void OrdersTest() {
        List<String> color = List.of(setOrderColor().toString());
        ordersData = new OrdersData("Naruto", "Uchiha", "Konoha, 142 apt.", 4, "+7 800 355 35 35", 5, "2020-06-06", "Saske, come back to Konoha", color); //здесь храняться данные
        TrackOrder response = given()
                .body(ordersData)
                .when()
                .post(ApiOrders)
                .then().log().all()
                .extract().as(TrackOrder.class);
        Assert.assertNotNull(response.getTrack());
    }
}
