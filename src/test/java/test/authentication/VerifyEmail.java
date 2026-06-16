package test.authentication;

import base.Thing_GetItApi;
import constant.StatusCode;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyEmail {
    @Test
    public void verifyEmailTest() {

        Response response = Thing_GetItApi.registerAndVerifyEmail();
        response.prettyPrint();
        System.out.println(response.statusCode());
        Assert.assertEquals(response.statusCode(), StatusCode.CODE_200.getCode());

    }
}
