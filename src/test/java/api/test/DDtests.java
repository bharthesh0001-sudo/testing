package api.test;

import api.endpoints.UserEndpoints;
import api.payload.User;
import io.restassured.response.Response;
import org.testng.Assert;

import org.testng.annotations.Test;
import api.utillities.DataProviders;

public class DDtests {


    @Test(priority = 1,dataProvider = "UserData",dataProviderClass= DataProviders.class)
    public void testPostUser(String userId,String username ,String fname, String lname, String useremail, String password, String ph )
    {
        User userpayload=new User();
        userpayload.setId(Integer.parseInt(userId));
        userpayload.setUsername(username);
        userpayload.setFirstName(fname);
        userpayload.setLastName(lname);
        userpayload.setEmail(useremail);
        userpayload.setPassword(password);
        userpayload.setPhone(ph);

        Response response= UserEndpoints.CreateUser(userpayload);

        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);

    }
    @Test(priority = 2,dataProvider = "userName",dataProviderClass = DataProviders.class)
    public void testDeleteuserByName(String username)

    {
      Response response = UserEndpoints.deleteUser(username);
      Assert.assertEquals(response.getStatusCode(),200);

    }


}
