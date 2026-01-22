package day2;
import netscape.javascript.JSException;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.openqa.selenium.json.Json;
import org.testng.annotations.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class WaysToCreatePostRequestBody {

    //post request body using Hashmap

    //@Test (priority = 1)
    void testPostusingHashmap()
    {
      HashMap data=new HashMap() ;
      data.put("name","techy");
      data.put("location","bangaluru");
      data.put("phone","1212");

       String courseArr[]={"c","c++"};
       data.put("courses",courseArr);


       given()
               .contentType("application/json")
               .body(data)
               .when()
               .post("https://jsonplaceholder.typicode.com/posts/")
               .then()
               .statusCode(201)
               .body("name",equalTo("techy"))
               .body("location",equalTo("bangaluru"))
               .body("phone",equalTo("1212"))
               .body("courses[0]",equalTo("c"))
               .body("courses[1]",equalTo("c++"))
               .header("Content-type","application/json; charset=utf-8")
               .log().all();


    }
    @Test(priority = 2)
    void  testDelete()
    {
        given()
                .when()
                .delete("https://jsonplaceholder.typicode.com/posts/1")
                .then()
                .statusCode(200);
    }


    //@Test (priority = 1)
    void testPostusingJsonlibrary()
    {


       JSONObject data= new JSONObject();
        data.put("name","techy");
        data.put("location","tumakuru");
        data.put("phone","123456");

        String coursesArr[]={"c","c++"};
        data.put("courses",coursesArr);


        given()
                .contentType("application/json")
                .body(data.toString())
                .when()
                .post("https://jsonplaceholder.typicode.com/posts")
                .then()
                .statusCode(201)
                .body("name",equalTo("techy"))
                .body("location",equalTo("tumakuru"))
                .body("phone",equalTo("123456"))
                .body("courses[0]",equalTo("c"))
                .body("courses[1]",equalTo("c++"))
                .header("Content-type","application/json; charset=utf-8")
                .log().all();


    }

    @Test (priority = 1)
    void testPostusingPOJO()
    {


        Pojo_PostRquest data=new Pojo_PostRquest();
        data.setName("techy");
        data.setLocation("tumakuru");
        data.setPhone("123456");
        String coursesArr[]={"c","c++"};
        data.setCourses(coursesArr);

        given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("https://jsonplaceholder.typicode.com/posts")
                .then()
                .statusCode(201)
                .body("name",equalTo("techy"))
                .body("location",equalTo("tumakuru"))
                .body("phone",equalTo("123456"))
                .body("courses[0]",equalTo("c"))
                .body("courses[1]",equalTo("c++"))
                .header("Content-type","application/json; charset=utf-8")
                .log().all();


    }



}
