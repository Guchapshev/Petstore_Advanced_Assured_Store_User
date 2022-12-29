package DomashkaTests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static helpers.Utils.readFile;
import static io.restassured.RestAssured.given;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AdvancedUser extends AdvancedUserBase {

    String requestUserObject = null;
    String requestUserArray = null;
    Integer userId = 360000;
    String username = "Shadida";


    {
        String initialBody = null;
        try {
            initialBody = readFile("src/test/resources/user.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JSONObject UserObject = new JSONObject(initialBody)
                .put("id", userId)
                .put("username", "Shadida")
                .put("firstName", "Toto")
                .put("lastName", "Dlip")
                .put("email", "klsd@mks.com")
                .put("password", "k123")
                .put("phone", "+23 0293")
                .put("userStatus", 1);
        requestUserObject = UserObject.toString();

        JSONArray UserArray = new JSONArray()
                .put(UserObject);
        requestUserArray = UserArray.toString();

    }

    @Test
    @DisplayName("Create user with Array")
    @Order(1)
    public void testUser1_1() throws IOException {

        given(getCreateUserArraySpec(requestUserArray))
                .post()
                .then()
                .spec(getCreateUserArrayResp());

    }

    @Test
    @DisplayName("Create user with List")
    @Order(2)
    public void testUser2_1() throws IOException {

        given(getCreateUserListSpec(requestUserArray))
                .post()
                .then()
                .spec(getCreateUserListResp());

    }

    @Test
    @Order(3)
    @DisplayName("Username")
    public void testUser3_1() {

        given(getUsernameSpec(username))
                .get()
                .then()
                .spec(getUsernameResp(userId, username));

    }

    @Test
    @DisplayName("Update username")
    @Order(4)
    public void testUser4_1() throws IOException {

        //Изменяем тело запроса
        JSONObject UserObject = new JSONObject()
                .put("id", 8797987);

        given(getUsernameUpdateSpec(UserObject.toString()))
                .put()
                .then()
                .spec(getUsernameUpdateResp("8797987"));
    }

    @Test
    @Order(5)
    @DisplayName("User delete")
    public void testUser5_1() {

        given(getUserDeleteSpec(username))
                .delete()
                .then()
                .spec(getAssertionSpec200());
    }

    @Test
    @Order(6)
    @DisplayName("User login")
    public void testUser6_1() {

        given(getUserLoginSpec("sdfsdf", "lkjdsf"))
                .get()
                .then()
                .spec(getUserLoginResp());
    }

    @Test
    @Order(7)
    @DisplayName("User logout")
    public void testUser7_1() {

        given(getUserLogoutSpec())
                .get()
                .then()
                .spec(getUserLogoutResp());
    }

    @Test
    @DisplayName("Create user")
    @Order(8)
    public void testUser8_1() throws IOException {

        given(getCreateUserSpec(requestUserObject))
                .post()
                .then()
                .spec(getCreateUserResp());

    }

    @Test
    @DisplayName("Negative_1 Create user with Array")
    @Order(9)
    public void testUser1_2() throws IOException {

        given(getCreateUserArraySpec(requestUserObject))
                .post()
                .then()
                .statusCode(500);

    }

    @Test
    @DisplayName("Negative_1 Create user with List")
    @Order(10)
    public void testUser2_2() throws IOException {

        given(getCreateUserListSpec(requestUserObject))
                .post()
                .then()
                .statusCode(500);

    }

    @Test
    @Order(11)
    @DisplayName("Negative_1 Username")
    public void testUser3_2() {

        given(getUsernameSpec("360000"))
                .get()
                .then()
                .statusCode(404);

    }

    @Test
    @Order(12)
    @DisplayName("Negative_1 Update username")
    public void testUser4_2() throws IOException {

        //Изменяем тело запроса
        JSONObject UserObject = new JSONObject()
                .put("id", "360000");

        given(getUsernameUpdateSpec(UserObject.toString()))
                .get()
                .then()
                .statusCode(404);
    }


    @Test
    @Order(13)
    @DisplayName("Negative_1 User delete")
    public void testUser5_2() {

        given(getUserDeleteSpec("jghhjgkgkjh"))
                .delete()
                .then()
                .statusCode(404);
    }

    @Test
    @Order(14)
    @DisplayName("Negative_1 User login")
    public void testUser6_2() {

        given(getUserLoginSpec("asdasd","asdasd"))
                .put()
                .then()
                .statusCode(405);
    }

    @Test
    @Order(15)
    @DisplayName("Negative_1 User logout")
    public void testUser7_2() {

        given(getUserLogoutSpec())
                .put()
                .then()
                .statusCode(405);
    }

    @Test
    @DisplayName("Negative_1 Create user")
    @Order(16)
    public void testUser8_2() throws IOException {

        given(getCreateUserSpec(requestUserArray))
                .post()
                .then()
                .statusCode(500);

    }

    @Test
    @DisplayName("Negative_2 Create user with Array")
    @Order(17)
    public void testUser1_3() throws IOException {

        given(getCreateUserArraySpec(requestUserArray))
                .patch()
                .then()
                .statusCode(405);

    }

    @Test
    @DisplayName("Negative_2 Create user with List")
    @Order(18)
    public void testUser2_3() throws IOException {

        given(getCreateUserListSpec(requestUserArray))
                .patch()
                .then()
                .statusCode(405);

    }

    @Test
    @Order(19)
    @DisplayName("Negative_2 Username")
    public void testUser3_3() {

        given(getUsernameSpec(username))
                .put()
                .then()
                .statusCode(405);

    }

    @Test
    @Order(20)
    @DisplayName("Negative_2 Update username")
    public void testUser4_3() throws IOException {

        //Изменяем тело запроса
        JSONObject UserObject = new JSONObject()
                .put("id", "360000");

        given(getUsernameUpdateSpec(UserObject.toString()))
                .delete()
                .then()
                .statusCode(404);
    }

    @Test
    @Order(21)
    @DisplayName("Negative_2 User delete")
    public void testUser5_3() {

        given(getUserDeleteSpec(username))
                .patch()
                .then()
                .statusCode(405);
    }

    @Test
    @Order(22)
    @DisplayName("Negative_2 User login")
    public void testUser6_3() {

        given(getUserLoginSpec("asdasd","asdasd"))
                .delete()
                .then()
                .statusCode(405);
    }

    @Test
    @Order(23)
    @DisplayName("Negative_2 User logout")
    public void testUser7_3() {

        given(getUserLogoutSpec())
                .delete()
                .then()
                .statusCode(405);
    }

    @Test
    @DisplayName("Negative_2 Create user")
    @Order(24)
    public void testUser8_3() throws IOException {

        given(getCreateUserSpec(requestUserObject))
                .put()
                .then()
                .statusCode(405);

    }


}
