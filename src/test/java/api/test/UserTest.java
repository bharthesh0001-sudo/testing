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
        userPayload.setUsername(faker.name().username());
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

@Test(priority = 3)
    public void testUpdateUserByName()
{


    //update data using payload
    userPayload.setFirstName(faker.name().firstName());
    userPayload.setLastName(faker.name().lastName());
    userPayload.setEmail(faker.internet().safeEmailAddress());




    Response respose=UserEndpoints.updateUser(this.userPayload.getUsername(),userPayload);
    respose.then().log().all();

    Assert.assertEquals(respose.getStatusCode(),200);



    //checking data after update

    Response responsAfterupdate=UserEndpoints.ReadUser(this.userPayload.getUsername());
    Assert.assertEquals(respose.getStatusCode(),200);

}
@Test(priority = 4)
public void testDeleteUserByName()
{
   Response response= UserEndpoints.deleteUser(this.userPayload.getUsername());
   Assert.assertEquals(response.getStatusCode(),200);

}

}

