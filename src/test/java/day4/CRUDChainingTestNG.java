package day4;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class CRUDChainingTestNG {

    // STEP 0: class level variable
    int userId;

    // STEP 1: CREATE USER
    @Test(priority = 1)
    void createUser() {

        userId =
                given()
                        .contentType("application/json")
                        .body("{ \"name\": \"Bharth\", \"job\": \"Tester\" }")
                        .when()
                        .post("https://reqres.in/api/users")
                        .then()
                        .statusCode(201)
                        .extract()
                        .jsonPath()
                        .getInt("id");

        System.out.println("User Created with ID: " + userId);
    }

    // STEP 2: GET USER
    @Test(priority = 2)
    void getUser() {

        given()
                .when()
                .get("https://reqres.in/api/users/" + userId)
                .then()
                .statusCode(200);

        System.out.println("User Retrieved: " + userId);
    }

    // STEP 3: UPDATE USER
    @Test(priority = 3)
    void updateUser() {

        given()
                .contentType("application/json")
                .body("{ \"name\": \"Bharth Updated\", \"job\": \"Senior Tester\" }")
                .when()
                .put("https://reqres.in/api/users/" + userId)
                .then()
                .statusCode(200);

        System.out.println("User Updated: " + userId);
    }

    // STEP 4: DELETE USER
    @Test(priority = 4)
    void deleteUser() {

        given()
                .when()
                .delete("https://reqres.in/api/users/" + userId)
                .then()
                .statusCode(204);

        System.out.println("User Deleted: " + userId);
    }
}

