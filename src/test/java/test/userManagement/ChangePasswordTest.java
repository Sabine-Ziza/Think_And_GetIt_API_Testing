package test.userManagement;

import base.Thing_GetItApi;
import constant.StatusCode;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ChangePasswordTest {
    @Test
    public void changePasswordTest(){
        Response response = Thing_GetItApi.getChangePassword();
        assertEquals(response.statusCode(), StatusCode.CODE_200.getCode());
    }
}
