
package test.authentication;

import base.Thing_GetItApi;
import constant.StatusCode;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void enterCredentials() {
        Response response = Thing_GetItApi.login();

        System.out.println("Response Body: " + response.asPrettyString());
        Assert.assertEquals(response.statusCode(), StatusCode.CODE_200.getCode());
        Assert.assertEquals(
                response.jsonPath().getString("data.user.role"),
                "ADMIN"
        );
    }
}