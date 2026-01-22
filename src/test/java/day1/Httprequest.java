package day1;
//import org.junit.Test;
import org.testng.annotations.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Httprequest {
    int id;
    @Test (priority = 1)
    public void getUser() {


        given()
                .baseUri("https://jsonplaceholder.typicode.com")

                .when()
                .get("/posts/1")

                .then()
                    .statusCode(200)
                .body("id", equalTo(1))
                .log().all();

    }
     @Test(priority = 2)
    void createUser ()
    {
        HashMap hm=new HashMap();
        hm.put("name","bharth");
        hm.put("job","tester");

        id = given()
                .contentType("application/json")
                .body(hm)
                .when()
                .post("https://jsonplaceholder.typicode.com/posts")
                .then()
                .statusCode(201)
                .extract()
                .jsonPath()
                .getInt("id");

        System.out.println("Generated ID = " + id);

    }

    @Test(priority = 3 ,dependsOnMethods = {"createUser"})

    void  updateUser()
    {

        HashMap hm=new HashMap();
        hm.put("name","bharthesh");
        hm.put("job","ias");


        given()
                .contentType("application/json")
                .body(hm)
                .when()
                .put("https://jsonplaceholder.typicode.com/posts/1")
                .then()
                .statusCode(200)
                .log().all();


    }
    @Test(priority = 4)
    void deleteUser() {

        given()
                .when()
                .delete("https://jsonplaceholder.typicode.com/posts/1")
                .then()
                .statusCode(200)   // JSONPlaceholder returns 200
                .log().all();
    }




}

