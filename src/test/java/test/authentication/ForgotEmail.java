package test.authentication;

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
        Assert.assertTrue(loginRequest.jsonPath().getBoolean("success"));
        Assert.assertEquals(
                loginRequest.jsonPath().getString("message"),
                "If an account with that email exists, a reset link has been sent."
        );


    }

    @Test
    public void resetPassword() {
        Response resetRequest = Thing_GetItApi.ResetPassword();
        resetRequest.prettyPrint();
        Assert.assertEquals(resetRequest.statusCode(), StatusCode.CODE_200.getCode());
        Assert.assertTrue(resetRequest.jsonPath().getBoolean("success"));
        Assert.assertEquals(
                resetRequest.jsonPath().getString("message"),
                "If an account with that email exists, a reset link has been sent."
        );

    }
}
