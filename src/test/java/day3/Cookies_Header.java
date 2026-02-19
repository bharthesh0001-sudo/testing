package day3;

import com.github.dockerjava.transport.DockerHttpClient;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class Cookies_Header {
    @Test (priority = 1)
    void  testCookies()
    {
        given()
                .when()
                .get("https://www.google.com/")

                .then()
                .cookie("AEC","AaJma5t1lEaoXFMnlvYT8GJhBi2sWtZbjWUDSmG3iVSB10efC-g5d7da9dM")
                .log().all();

///
    }
    @Test(priority = 2)
    void  getCookies()
    {
         Response res=given()
                .when()
                .get("https://www.google.com/");
             // get single cookies info
         //String cookie_value = res.getCookie("AEC");
       // System.out.println("value of cookie is ====>" +cookie_value);

      Map<String,String>  cookies_values=  res.getCookies();

       // System.out.println(cookies_values.keySet());
       for( String k:cookies_values.keySet()){
           String cookie_value = res.getCookie(k);
           System.out.println(k+"    "+cookie_value);
       }

    }





}
