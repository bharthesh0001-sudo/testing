package day3;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.response.Response;
public class Logging_Demo {

    @Test(priority = 1)
    void testLog()
    {
        given()
                .when()
                .get("https://www.google.com/")
                .then()
                .log().all();
    }



}
