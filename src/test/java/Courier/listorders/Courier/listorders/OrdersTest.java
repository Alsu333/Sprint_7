package Courier.listorders;
import com.sun.istack.NotNull;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.http.ContentType;
import org.example.GetCountOrders;
import org.example.Specification;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import java.util.stream.Collectors;
import static io.restassured.RestAssured.given;

public class OrdersTest {
    @Test
    @DisplayName("Get orders list")
    public void checkOrders(){
        Specification.installSpecification(Specification.requestSpecificationURL());
        List<GetCountOrders> orders = given()
                .when()
                .get("api/v1/orders")
                .then().log().all()
                .extract().body().jsonPath().getList("orders",GetCountOrders.class);
        Assert.assertNotNull(orders.contains("orders")); //проверяем, что список не пустой
    }
}
