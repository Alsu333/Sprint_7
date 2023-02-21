package courier.listorders;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.metods.Orders;
import org.example.models.GetCountOrders;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.example.models.Constants.Constant.BASE_URL;

public class OrdersTest {
    @Before
    public void setUp() {
        RestAssured.baseURI = BASE_URL;
    }

    @Test
    @DisplayName("Get orders list")
    public void checkOrders() {
        Response response = Orders.ListOfOrders();
        response.then().log().all()
                .extract().body().jsonPath().getList("orders", GetCountOrders.class);
        Assert.assertNotNull(response);
    }
}
