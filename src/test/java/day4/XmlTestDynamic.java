package day4;
import io.restassured.response.Response;
 import static io.restassured.RestAssured.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class XmlTestDynamic {

    @Test
    public void testAllBooksXML() {

        // 1 Send GET request
        Response res = given()
                .when()
                .get("https://www.w3schools.com/xml/books.xml");

        // 2 Validate status code
        Assert.assertEquals(res.getStatusCode(), 200);

        // 3 Validate Content-Type header
        Assert.assertTrue(res.header("content-type").contains("text/xml"));

        // 4 Get all <book> nodes as List
        List<Object> books = res.xmlPath().getList("bookstore.book");
        System.out.println("Total books: " + books.size());

        // 5 Iterate through all books and validate details dynamically
        for (int i = 0; i < books.size(); i++) {

            // Get title
            String title = res.xmlPath().getString("bookstore.book[" + i + "].title");
            System.out.println("Book " + (i+1) + " Title: " + title);

            // Get author(s)
            List<String> authors = res.xmlPath().getList("bookstore.book[" + i + "].author");
            System.out.println("Book " + (i+1) + " Author(s): " + authors);

            // Get year
            String year = res.xmlPath().getString("bookstore.book[" + i + "].year");
            System.out.println("Book " + (i+1) + " Year: " + year);

            // Get price
            String price = res.xmlPath().getString("bookstore.book[" + i + "].price");
            System.out.println("Book " + (i+1) + " Price: " + price);

            // Get category (attribute)
            String category = res.xmlPath().getString("bookstore.book[" + i + "].@category");
            System.out.println("Book " + (i+1) + " Category: " + category);

            // Example assertions (you can customize per your expected data)
            Assert.assertNotNull(title, "Title is NULL - book title is missing in response");
            Assert.assertNotNull(authors, "Authors is NULL - author details are missing");
            Assert.assertNotNull(year, "Year is NULL - published year  missing");
            Assert.assertNotNull(price, "Price is NULL - book price  missing");
            Assert.assertNotNull(category, "Categor");

            System.out.println("--------------------------");
        }
    }
}

