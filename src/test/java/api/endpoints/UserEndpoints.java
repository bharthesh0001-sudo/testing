package api.endpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import api.payload.User;
import api.endpoints.routes;



//usr Endpoint .java
//CRUD perform

public class UserEndpoints {


     public static Response CreateUser(User payload)
    {
     Response res = given()
              .contentType(ContentType.JSON)
              .accept(ContentType.JSON)
              .body(payload)

              .when()
              .post(routes.post_url);
            return res;

    }
    public static Response ReadUser(String username)
    {
        Response res = given()
                .pathParam("username",username)

                .when()
                .get(routes.get_url);
        return res;

    }
    public static Response updateUser(String username ,User payload)
    {
        Response res = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username",username)
                .body(payload)
                .when()
                .put(routes.update_url);
        return res;

    }
    public static Response deleteUser(String username) {
        Response res = given()
                .pathParam("username", username)
                .when()
                .delete(routes.delete_url);

        return res;
    }

}

