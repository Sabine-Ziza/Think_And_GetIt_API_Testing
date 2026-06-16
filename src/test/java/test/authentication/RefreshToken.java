package test.authentication;

import base.Thing_GetItApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RefreshToken {
    @Test
    public void refreshTokenTest() {
        Response refreshRequest = Thing_GetItApi.RefreshToken();
        refreshRequest.prettyPrint();
        Assert.assertTrue(refreshRequest.jsonPath().getBoolean("success"));
        Assert.assertEquals(refreshRequest.jsonPath().getString("message"), "Success");
        String token = refreshRequest.jsonPath().getString("data.token");
        Assert.assertNotNull(token);
        Assert.assertFalse(token.isEmpty());
    }
}

