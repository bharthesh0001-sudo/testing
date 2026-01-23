package day4;
import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
public class ParsingJSonResponceData {
    @Test(priority = 1)
    void testJsonResponse() {
        /*given()
                .contentType("content type.JSON")
                .when()
                .get("")
                .then()
                .statusCode(200)
                .header("content-type","application/json; charset=utf=8")
                .body("x.products[4]",equalto("Red Nail Polish"))



         Response res=given()
                .contentType("application/json")
                .when()
                .get("http://localhost:3000/Store");

        Assert.assertEquals(   res.getStatusCode(),200);
         Assert.assertEquals(res.header("content-type"),"application/json; charset=utf-8");
             String bookname=res.jsonPath().get("book[3].tittle").toString();
             Assert.assertEquals(bookname,"the lord of rings ");

*/
        Response res = given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://dummyjson.com/products");
        //using JSONOBJECT  classs
        JSONObject jo = new JSONObject(res.asString());

        //print alll tittles
       /* for(int i=0;i<jo.getJSONArray("products").length();i++)
        {
          String producttittle = jo.getJSONArray("products").getJSONObject(i).get("title").toString();
            System.out.println(producttittle);
        }
         */
        //search for validation of book
        boolean status = false;
        for (int i = 0; i < jo.getJSONArray("products").length(); i++) {
            String producttittle = jo.getJSONArray("products").getJSONObject(i).get("title").toString();
            if (producttittle.equals("Red Nail Polish")) {
                status = true;
                break;

            }
        }

        Assert.assertEquals(status, true);


//total price of proctuct
        double totalprice = 0;
        for (int i = 0; i < jo.getJSONArray("products").length(); i++) {
            String price = jo.getJSONArray("products").getJSONObject(i).get("price").toString();
            totalprice = totalprice + Double.parseDouble(price);

        }
        System.out.println("total price of procts:" + totalprice);
        Assert.assertEquals(totalprice, 6577.499999999995);


    }


    @Test(priority = 2)
    void testUsingJsonPath() {

        /*Response res = given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://dummyjson.com/products");

        // Convert response to JsonPath
        JsonPath jp = res.jsonPath();

        //  Search for product (Red Nail Polish)
        boolean status = false;
        int productCount = jp.getInt("products.size()");

        for (int i = 0; i < productCount; i++) {
            String title = jp.getString("products[" + i + "].title");

            if (title.equals("Red Nail Polish")) {
                status = true;
                break;
            }
        }

        Assert.assertEquals(status, true);

        // Total price calculation
        double totalPrice = 0;

        for (int i = 0; i < productCount; i++) {
            double price = jp.getDouble("products[" + i + "].price");
            totalPrice = totalPrice + price;
        }

        System.out.println("Total price of products: " + totalPrice)
        // Better assertion for decimal values
        Assert.assertEquals(totalPrice, 6577.5, 0.01);
    }

         */

    // Get response
    Response res = given()
            .contentType(ContentType.JSON)
            .when()
            .get("https://dummyjson.com/products");

    // Convert to JsonPath
    JsonPath jp = res.jsonPath();


    //  Search product WITHOUT LOOP
    String title = jp.getString(
            "products.find { it.title == 'Red Nail Polish' }.title"
    );

// Validation
Assert.assertEquals(title, "Red Nail Polish");


    // Total price WITHOUT LOOP
    Double totalPrice = jp.getDouble(
            "products.price.sum()"
    );

System.out.println("Total price of products: " + totalPrice);

// Assertion with tolerance
Assert.assertEquals(totalPrice, 6577.5, 0.01);

}}