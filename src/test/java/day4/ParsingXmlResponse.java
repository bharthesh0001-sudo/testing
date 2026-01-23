package day4;
import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ParsingXmlResponse {

    @Test
    void testXmlResponse() {
/*
        Response res = given()
                .when()
                .get("https://www.w3schools.com/xml/books.xml");

        // Convert response to XmlPath
        XmlPath xp = new XmlPath(res.asString());

        // Get first book title
        String title = xp.getString("bookstore.book[0].title");
        System.out.println("First book title: " + title);

        Assert.assertEquals(title, "Everyday Italian");

        // Total number of books
        int bookCount = xp.getInt("bookstore.book.size()");
        System.out.println("Total books: " + bookCount);

        Assert.assertEquals(bookCount, 4);





        given()
                .when()
                .get("https://www.w3schools.com/xml/books.xml")
                .then()
                .statusCode(200)
                .header("Content-Type","text/xml; charset=utf-8")
                .body("bookstore.book[0].title",   equalTo("Everyday Italian"))
                .body("bookstore.book[1].author", equalTo("J K. Rowling"));



 */

        Response res1= given()
                .when()
                .get("https://www.w3schools.com/xml/books.xm");

        Assert.assertEquals(res1.getStatusCode(),200);
        Assert.assertEquals(res1.header("Content-Type"),"text/xm; charset=utf-8");
      String bookname = res1.xmlPath().getString("bookstore.book");







    }
}

