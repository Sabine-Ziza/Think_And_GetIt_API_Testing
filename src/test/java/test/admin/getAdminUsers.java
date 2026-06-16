package test.admin;

import base.Thing_GetItApi;
import constant.StatusCode;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class getAdminUsers {
    @Test
    public void getAdminusersTest(){
        Response response = Thing_GetItApi.getAdminUser();
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), StatusCode.CODE_200.getCode());
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        Assert.assertEquals(
                response.jsonPath().getString("message"),
                "Success"
        );

        Assert.assertNotNull(
                response.jsonPath().getString("data[0].email")
        );
        Assert.assertNotNull(
                response.jsonPath().getBoolean("data[0].isVerified")
        );

    }


}
