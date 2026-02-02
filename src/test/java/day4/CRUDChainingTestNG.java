package day4;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class CRUDChainingTestNG {

    // STEP 0: class level variable
    int userId;

    // STEP 1: CREATE USER
    /*@Test(priority = 1)
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


     */

    String token;
    int bookingId;

    // STEP 1: CREATE TOKEN
    @Test(priority = 1)
    void createToken() {

        token =
        given()
            .contentType("application/json")
            .body("{ \"username\": \"admin\", \"password\": \"password123\" }")
        .when()
            .post("https://restful-booker.herokuapp.com/auth")
        .then()
            .statusCode(200)
            .extract()
            .jsonPath()
            .getString("token");

        System.out.println("Token: " + token);
    }

    // STEP 2: CREATE BOOKING
    @Test(priority = 2)
    void createBooking() {

        bookingId =
        given()
            .contentType("application/json")
            .body("{\n" +
                    "\"firstname\": \"Bharth\",\n" +
                    "\"lastname\": \"Tester\",\n" +
                    "\"totalprice\": 1200,\n" +
                    "\"depositpaid\": true,\n" +
                    "\"bookingdates\": {\n" +
                    "   \"checkin\": \"2024-01-01\",\n" +
                    "   \"checkout\": \"2024-01-10\"\n" +
                    "},\n" +
                    "\"additionalneeds\": \"Breakfast\"\n" +
                    "}")
        .when()
            .post("https://restful-booker.herokuapp.com/booking")
        .then()
            .statusCode(200)
            .extract()
            .jsonPath()
            .getInt("bookingid");

        System.out.println("Booking ID: " + bookingId);
    }

    // STEP 3: GET BOOKING
    @Test(priority = 3)
    void getBooking() {

        given()
        .when()
            .get("https://restful-booker.herokuapp.com/booking/" + bookingId)
        .then()
            .statusCode(200);

        System.out.println("Booking Retrieved: " + bookingId);
    }

    // STEP 4: UPDATE BOOKING
    @Test(priority = 4)
    void updateBooking() {

        given()
            .contentType("application/json")
            .header("Cookie", "token=" + token)
            .body("{\n" +
                    "\"firstname\": \"Bharth Updated\",\n" +
                    "\"lastname\": \"Senior Tester\",\n" +
                    "\"totalprice\": 1500,\n" +
                    "\"depositpaid\": true,\n" +
                    "\"bookingdates\": {\n" +
                    "   \"checkin\": \"2024-02-01\",\n" +
                    "   \"checkout\": \"2024-02-15\"\n" +
                    "},\n" +
                    "\"additionalneeds\": \"Lunch\"\n" +
                    "}")
        .when()
            .put("https://restful-booker.herokuapp.com/booking/" + bookingId)
        .then()
            .statusCode(200);

        System.out.println("Booking Updated: " + bookingId);
    }

    // STEP 5: DELETE BOOKING
    @Test(priority = 5)
    void deleteBooking() {

        given()
            .header("Cookie", "token=" + token)
        .when()
            .delete("https://restful-booker.herokuapp.com/booking/" + bookingId)
        .then()
            .statusCode(201);

        System.out.println("Booking Deleted: " + bookingId);
    }
}
