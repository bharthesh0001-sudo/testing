package day3;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PathAndQueryParam {


    @Test
    void  testQueryPara(){
//https://httpbin.org/get?user=users&page=2&id=5


        given()
                .pathParam("mypath","get")
                .queryParam("page",2)
                .queryParam("id",5)
                .when()
                       .get("https://httpbin.org/{mypath}")
                .then()
                .statusCode(200)
                .log().all();





    }



}
