package tests;

import day5.BaseTest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BookingTest extends BaseTest {

    String token;
    int bookingId;

    //  CREATE TOKEN
    @Test(priority = 1)
    public void createToken() {

        token =
                given()
                        .contentType("application/json")
                        .body("{ \"username\": \"admin\", \"password\": \"password123\" }")
                        .when()
                        .post("/auth")
                          .then()
                        .statusCode(200)
                        .extract()
                        .jsonPath()
                        .getString("token");

        System.out.println("TOKEN = " + token);
    }

    // CREATE BOOKING
    @Test(priority = 2)
    public void createBooking() {

        bookingId =
                given()
                        .contentType("application/json")
                        .body("{\n" +
                                "\"firstname\": \"Bharth\",\n" +
                                "\"lastname\": \"Tester\",\n" +
                                "\"totalprice\": 1000,\n" +
                                "\"depositpaid\": true,\n" +
                                "\"bookingdates\": {\n" +
                                "   \"checkin\": \"2024-01-01\",\n" +
                                "   \"checkout\": \"2024-01-05\"\n" +
                                "},\n" +
                                "\"additionalneeds\": \"Breakfast\"\n" +
                                "}")
                        .when()
                        .post("/booking")
                        .then()
                        .statusCode(200)
                        .extract()
                        .jsonPath()
                        .getInt("bookingid");

        System.out.println("BOOKING ID = " + bookingId);
    }

    // GET BOOKING
    @Test(priority = 3)
    public void getBooking() {

        given()
                .when()
                .get("/booking/" + bookingId)
                .then()
                .statusCode(200);

        System.out.println("GET BOOKING SUCCESS");
    }

    //  UPDATE BOOk
    @Test(priority = 4)
    public void updateBooking() {

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
                        "   \"checkout\": \"2024-02-10\"\n" +
                        "},\n" +
                        "\"additionalneeds\": \"Lunch\"\n" +
                        "}")
                .when()
                .put("/booking/" + bookingId)
                .then()
                .statusCode(200);

        System.out.println("UPDATE SUCCESS");
    }

    //  DELETE BOOKING
    @Test(priority = 5)
    public void deleteBooking() {

        given()
                .header("Cookie", "token=" + token)
                .when()
                .delete("/booking/" + bookingId)
                .then()
                .statusCode(201);

        System.out.println("DELETE SUCCESS");
    }
}
