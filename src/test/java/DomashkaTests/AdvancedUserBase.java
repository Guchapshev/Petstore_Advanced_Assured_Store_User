package DomashkaTests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeEach;

import static org.hamcrest.Matchers.*;

public class AdvancedUserBase {

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

/**
 * POST
 * /user/createWithArray
 * Creates list of users with given input array
 */
    /*
    Метод возвращает RequestSpecification для метода POST basUrl/user/createWithArray
     */
    protected RequestSpecification getCreateUserArraySpec(String body) {
        return new RequestSpecBuilder()
                .addRequestSpecification(getBaseSpecification())
                .setBasePath("/user/createWithArray")
                .setBody(body)
                .build();
    }
    /*
    Метод возвращает спецификацию проверки тела ответа на запрос POST basUrl/user/createWithArray
     */
    protected ResponseSpecification getCreateUserArrayResp() {
        ResponseSpecBuilder builder = new ResponseSpecBuilder();
        builder
                .addResponseSpecification(getAssertionSpec200())
                .expectBody("message", equalTo("ok"));
        return builder.build();
    }

/**
 * POST
 * /user/createWithList
 * Creates list of users with given input array
 */
    /*
    Метод возвращает RequestSpecification для метода POST basUrl/user/createWithList
     */
protected RequestSpecification getCreateUserListSpec(String body) {
    return new RequestSpecBuilder()
            .addRequestSpecification(getBaseSpecification())
            .setBasePath("/user/createWithList")
            .setBody(body)
            .build();
}
    /*
    Метод возвращает спецификацию проверки тела ответа на запрос POST basUrl/user/createWithList
     */
    protected ResponseSpecification getCreateUserListResp() {
        ResponseSpecBuilder builder = new ResponseSpecBuilder();
        builder
                .addResponseSpecification(getAssertionSpec200())
                .expectBody("message", equalTo("ok"));
        return builder.build();
    }

/**
 * GET
 * /user/{username}
 * Get user by user name
 */
    /*
    Метод возвращает RequestSpecification для метода GET basUrl/user/{username}
     */
protected RequestSpecification getUsernameSpec(String username) {
    return new RequestSpecBuilder()
            .addRequestSpecification(getBaseSpecification())
            .setBasePath("/user/" + username)
            .build();
}
    /*
    Метод возвращает спецификацию проверки тела ответа на запрос GET basUrl/user/{username}
     */
    protected ResponseSpecification getUsernameResp(int userId, String username) {
        ResponseSpecBuilder builder = new ResponseSpecBuilder();
        builder
                .addResponseSpecification(getAssertionSpec200())
                .expectBody("id", equalTo(userId))
                .expectBody("username", equalTo(username));
        return builder.build();
    }

/**
 * PUT
 * /user/{username}
 * Updated user
 */
    /*
    Метод возвращает RequestSpecification для метода PUT basUrl/user/{username}
     */
protected RequestSpecification getUsernameUpdateSpec(String body) {
    return new RequestSpecBuilder()
            .addRequestSpecification(getBaseSpecification())
            .setBasePath("/user/username")
            .setBody(body)
            .build();
}
    /*
    Метод возвращает спецификацию проверки тела ответа на запрос PUT basUrl/user/{username}
     */
    protected ResponseSpecification getUsernameUpdateResp(String id) {
        ResponseSpecBuilder builder = new ResponseSpecBuilder();
        builder
                .addResponseSpecification(getAssertionSpec200())
                .expectBody("message", equalTo(id));
        return builder.build();
    }

/**
 * DELETE
 * /user/{username}
 * Delete user
 */
    /*
    Метод возращает RequestSpecification для метода DELETE basUrl/store/order/{orderId}
     */
protected RequestSpecification getUserDeleteSpec(String username) {
    return new RequestSpecBuilder()
            .addRequestSpecification(getBaseSpecification())
            .setBasePath("/user/" + username)
            .build();
}

/**
 * GET
 * /user/login
 * Logs user into the system
 */
    /*
    Метод возвращает RequestSpecification для метода GET basUrl/user/login
     */
protected RequestSpecification getUserLoginSpec (String username, String password) {
    return new RequestSpecBuilder()
            .addRequestSpecification(getBaseSpecification())
            .setBasePath("/user/login")
            .addQueryParam("username", username)
            .addQueryParam("password", password)
            .build();

}
    /*
    Метод возвращает спецификацию проверки тела ответа на запрос GET basUrl/user/login
     */
    protected ResponseSpecification getUserLoginResp() {
        ResponseSpecBuilder builder = new ResponseSpecBuilder();
        builder
                .addResponseSpecification(getAssertionSpec200())
                .expectBody("code", equalTo(200));
        return builder.build();
    }

/**
 * GET
 * /user/logout
 * Logs out current logged in user session
 */
    /*
    Метод возвращает RequestSpecification для метода GET basUrl/user/login
     */
protected RequestSpecification getUserLogoutSpec () {
    return new RequestSpecBuilder()
            .addRequestSpecification(getBaseSpecification())
            .setBasePath("/user/logout")
            .build();

}
    /*
    Метод возвращает спецификацию проверки тела ответа на запрос GET basUrl/user/login
     */
    protected ResponseSpecification getUserLogoutResp() {
        ResponseSpecBuilder builder = new ResponseSpecBuilder();
        builder
                .addResponseSpecification(getAssertionSpec200())
                .expectBody("code", equalTo(200));
        return builder.build();
    }

/**
 * POST
 * /user
 * Create user
 */
    /*
    Метод возвращает RequestSpecification для метода POST basUrl/user
     */
protected RequestSpecification getCreateUserSpec(String body) {
    return new RequestSpecBuilder()
            .addRequestSpecification(getBaseSpecification())
            .setBasePath("/user")
            .setBody(body)
            .build();
}
    /*
    Метод возвращает спецификацию проверки тела ответа на запрос POST basUrl/user
     */
    protected ResponseSpecification getCreateUserResp() {
        ResponseSpecBuilder builder = new ResponseSpecBuilder();
        builder
                .addResponseSpecification(getAssertionSpec200())
                .expectBody("code", equalTo(200));
        return builder.build();
    }



}
