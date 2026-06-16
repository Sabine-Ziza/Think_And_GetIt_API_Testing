package test.authentication;

import base.Thing_GetItApi;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class RefreshToken {
    @Test
    public void refreshTokenTest() {
        Response refreshRequest = Thing_GetItApi.RefreshToken();
        refreshRequest.prettyPrint();
    }
}
