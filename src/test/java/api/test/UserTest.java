package api.test;

import api.endpoints.UserEndpoints;
import api.payload.User;

import io.restassured.response.Response;
import net.bytebuddy.asm.Advice;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class UserTest {

    Faker faker;
    User userPayload;

     String username;

    @BeforeClass
    public void setupDate()
    {
        faker=new Faker();
        userPayload=new User();

        username = faker.name().username();


        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(username);
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPassword(faker.internet().password(5,10));
        userPayload.setPhone(faker.phoneNumber().cellPhone());

    }

@Test(priority =1)
    public  void testPostUser()
{
  Response response = UserEndpoints.CreateUser(userPayload);
  response.then().log().all();
    Assert.assertEquals(response.getStatusCode(),200);

}
    @Test(priority = 2)
    public void testGetUserByName() {

        Response response = UserEndpoints.ReadUser(username);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);
    }



}
