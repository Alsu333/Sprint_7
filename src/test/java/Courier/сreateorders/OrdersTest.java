
import io.qameta.allure.junit4.DisplayName;
import org.example.OrdersData;
import org.example.Specification;
import org.example.TrackOrder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.given;

@RunWith(Parameterized.class)
public class OrdersTest { //тестовый класс с полями
private final List<String> colors;
    private OrdersData ordersData;
    public OrdersTest(List<String>colors) {
        this.colors=colors;
    }
        @Parameterized.Parameters
        public static Object[] setOrderColor() {
            return new Object[][]{
                    {List.of()},
                    {List.of("BLACK")},
                    {List.of("GRAY")},
                    //{List.of(ordersData.getColor().indexOf(0)),ordersData.getColor().indexOf(1)},
                    {List.of("GRAY", "BLACK")}// передали тестовые данные
            };
        }
        @Test
        @DisplayName("Get Order Test")
        public void OrdersTest() {
            Specification.installSpecification(Specification.requestSpecificationURL());
            //ArrayList<String> cocolor;
            //cocolor = (ArrayList<String>) List.of(setOrderColor().toString());
            List<String> color = List.of(setOrderColor().toString());
            //ordersData = colorsData.ordersData;
            ordersData = new OrdersData("Naruto", "Uchiha", "Konoha, 142 apt.", 4, "+7 800 355 35 35", 5, "2020-06-06", "Saske, come back to Konoha",color); //здесь храняться данные
            TrackOrder response = given()
                    .body(ordersData)
                    .when()
                    .post( "api/v1/orders")
                    .then().log().all()
                    .extract().as(TrackOrder.class);
            Assert.assertNotNull(response.getTrack());
        }
}