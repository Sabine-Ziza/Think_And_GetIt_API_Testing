package test;

import base.Thing_GetItApi;
import constant.StatusCode;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotEmail {

    @Test
    public void forgotEmailTest() {
        Response loginRequest = Thing_GetItApi.forgotPassword();
        loginRequest.prettyPrint();
        Assert.assertEquals(loginRequest.statusCode(), StatusCode.CODE_200.getCode());


    }

    @Test
    public void resetPassword() {
        Response resetRequest = Thing_GetItApi.ResetPassword();
        resetRequest.prettyPrint();
        Assert.assertEquals(resetRequest.statusCode(), StatusCode.CODE_200.getCode());

    }
}
