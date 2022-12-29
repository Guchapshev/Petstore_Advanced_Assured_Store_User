package DomashkaTests;


import org.json.JSONObject;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static helpers.Utils.readFile;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AdvancedStore extends AdvancedStoreBase {

    String requestOrderBody = null;
    String requestOrderNegative1 = null;
    String requestOrderNegative2 = null;
    Integer orderId = 567392;

    {
        String initialBody = null;
        try {
            initialBody = readFile("src/test/resources/store.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JSONObject jsonObject = new JSONObject(initialBody)
                .put("id", orderId)
                .put("quantity", 12);
        requestOrderBody = jsonObject.toString();
    }

    {
        String initialBody = null;
        try {
            initialBody = readFile("src/test/resources/store.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JSONObject jsonObject = new JSONObject(initialBody)
                .put("id", "Jeronimo");
        requestOrderNegative1 = jsonObject.toString();
    }

    {
        String initialBody = null;
        try {
            initialBody = readFile("src/test/resources/store.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JSONObject jsonObject = new JSONObject(initialBody)
                .put("quantity", "all");
        requestOrderNegative2 = jsonObject.toString();
    }

    @Test
    @DisplayName("Order placing")
    @Order(1)
    public void testStore1_1() throws IOException {

        given(getOrderPlacingSpec(requestOrderBody))
                .post()
                .then()
                .spec(getOrderPlacingResp());

    }

    @Test
    @Order(2)
    @DisplayName("Order info")
    public void testStore2_1() {

        given(getOrderInfoSpec("567392"))
                .get()
                .then()
                .spec(getOrderInfoResp(12,"placed", true));

    }

    @Test
    @Order(3)
    @DisplayName("Order delete")
    public void testStore3_1() {

        given(getOrderDeleteSpec("567392"))
                .delete()
                .then()
                .spec(getAssertionSpec200());
    }

    @Test
    @Order(4)
    @DisplayName("Inventory")
    public void testStore4_1() {

        given(getInventorySpec())
                .get()
                .then()
                .spec(getInventoryResp());
    }
    @Test
    @Order(5)
    @DisplayName("Negative_1 Order placing")
    public void testStore1_2() throws IOException {

        given(getOrderPlacingSpec(requestOrderNegative1))
                .post()
                .then()
                .statusCode(500);
    }

    @Test
    @Order(6)
    @DisplayName("Negative_1 Order info")
    public void testStore2_2() {

        given(getOrderInfoSpec("567392"))
                .get()
                .then()
                .statusCode(404);

    }

    @Test
    @Order(7)
    @DisplayName("Negative_1 Order delete")
    public void testStore3_2() {

        given(getOrderDeleteSpec("567392"))
                .delete()
                .then()
                .statusCode(404);
    }

    @Test
    @Order(8)
    @DisplayName("Negative_1 Inventory")
    public void testStore4_2() {

        given(getInventorySpec())
                .get("available")
                .then()
                .statusCode(404);
    }

    @Test
    @Order(9)
    @DisplayName("Negative_2 Order placing")
    public void testStore1_3() throws IOException {

        given(getOrderPlacingSpec(requestOrderNegative2))
                .post()
                .then()
                .statusCode(500);
    }

    @Test
    @Order(10)
    @DisplayName("Negative_2 Order info")
    public void testStore2_3() {

        given(getOrderInfoSpec("567392"))
                .get()
                .then()
                .statusCode(404);

    }

    @Test
    @Order(11)
    @DisplayName("Negative_2 Order delete")
    public void testStore3_3() {

        given(getOrderDeleteSpec("567392"))
                .delete()
                .then()
                .statusCode(404);
    }

    @Test
    @Order(12)
    @DisplayName("Negative_2 Inventory")
    public void testStore4_3() {

        given(getInventorySpec())
                .get("sold")
                .then()
                .statusCode(404);
    }
}
