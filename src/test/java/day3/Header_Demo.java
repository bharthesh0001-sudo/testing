package day3;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Header_Demo {

    @Test(priority = 1)
    void  testHeader()
    {
        given()
                .when()
                .get("https://www.google.com/")

                .then()
                .header("Content-Type", "text/html; charset=ISO-8859-1")
                .and()

                .header("Content-Encoding","gzip")
                .and()
                .header("Server","gws");

    }

    @Test(priority = 2)
    void  getHeader()
    {
        Response rest =given()
                .when()
                .get("https://www.google.com/");

              // get single header info
         //      String headervalue = rest.getHeader("Content-Type");
        //System.out.println("the value of content typeheader is :" +headervalue);
        //get all header info
         Headers myheaders= rest.getHeaders();
         for(Header hd:myheaders){
             System.out.println(hd.getName()+"   "+hd.getValue());
         }


    }

}


