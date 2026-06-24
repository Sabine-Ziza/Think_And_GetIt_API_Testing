package test.authentication;

import base.Thing_GetItApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GetCurrentUser {

    @Test
    public void getCurrentUserTest(){
        Response response =Thing_GetItApi.getCurrentUser();
        Assert.assertTrue(
                response.jsonPath().getBoolean("success"),
                "Login should be successful"
        );

        Assert.assertEquals(
                response.jsonPath().getString("message"),
                "Success"
        );


    }
}
