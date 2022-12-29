package DomashkaTests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeEach;

import static org.hamcrest.Matchers.equalTo;

public class AdvancedStoreBase {

    RequestSpecification specification;

    @BeforeEach
    public void beforeEach() {
        specification = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2")
                .addHeader("Accept","application/json")
                .addHeader("Content-Type","application/json;;charset=UTF-8")
                .addHeader("Accept-Encoding","gzip, deflate, br")
                .build();
    }

    private RequestSpecification getBaseSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2")
                .addHeader("Accept","application/json")
                .addHeader("Content-Type","application/json;;charset=UTF-8")
                .addHeader("Accept-Encoding","gzip, deflate, br")
                .addHeader("api_key", "api_key")
                .build();
    }


    /*
    Метод возвращает ResponseSpecification с проверкой кода статуса ответа
     */
    protected ResponseSpecification getAssertionSpec200() {
        ResponseSpecBuilder builder = new ResponseSpecBuilder();
        builder.expectStatusCode(200);
        return builder.build();
    }


    /*
    Метод возвращает RequestSpecification для метода POST basUrl/store/order
     */
    protected RequestSpecification getOrderPlacingSpec(String body) {
        return new RequestSpecBuilder()
                .addRequestSpecification(getBaseSpecification())
                .setBasePath("/store/order")
                .setBody(body)
                .build();
    }
    /*
    Метод возвращает спецификацию проверки тела ответа на запрос POST basUrl/store/order
     */
    protected ResponseSpecification getOrderPlacingResp() {
        ResponseSpecBuilder builder = new ResponseSpecBuilder();
        builder
                .addResponseSpecification(getAssertionSpec200())
                .expectBody("id", equalTo(567392))
                .expectBody("quantity", equalTo(12));
        return builder.build();
    }


    /*
    Метод возвращает RequestSpecification для метода GET basUrl/store/order/{orderId}
     */
    protected RequestSpecification getOrderInfoSpec(String orderId) {
        return new RequestSpecBuilder()
                .addRequestSpecification(getBaseSpecification())
                .setBasePath("/store/order/" + orderId)
                .build();
    }
    /*
    Метод возвращает спецификацию проверки тела ответа на запрос GET basUrl/store/order/{orderId}
     */
    protected ResponseSpecification getOrderInfoResp(int quantity, String status, boolean complete) {
        ResponseSpecBuilder builder = new ResponseSpecBuilder();
        builder
                .addResponseSpecification(getAssertionSpec200())
                .expectBody("quantity", equalTo(quantity))
                .expectBody("status", equalTo(status))
                .expectBody("complete", equalTo(complete));
        return builder.build();
    }


    /*
    Метод возращает RequestSpecification для метода DELETE basUrl/store/order/{orderId}
     */
    protected RequestSpecification getOrderDeleteSpec(String orderId) {
        return new RequestSpecBuilder()
                .addRequestSpecification(getBaseSpecification())
                .setBasePath("/store/order/" + orderId)
                .build();
    }


    /*
    Метод возращает RequestSpecification для метода GET basUrl/store/inventory
     */
    protected RequestSpecification getInventorySpec() {
        return new RequestSpecBuilder()
                .addRequestSpecification(getBaseSpecification())
                .setBasePath("/store/inventory")
                .build();
    }
    /*
    Метод возвращает спецификацию для проверки тела ответа на запрос GET basUrl/store/inventory
     */
    protected ResponseSpecification getInventoryResp() {
        ResponseSpecBuilder builder = new ResponseSpecBuilder();
        builder
                .addResponseSpecification(getAssertionSpec200());
        return builder.build();
    }

}
