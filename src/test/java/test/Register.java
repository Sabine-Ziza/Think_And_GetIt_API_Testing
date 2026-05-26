package test;

import base.Data;
import base.Thing_GetItApi;
import constant.StatusCode;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Register {
    @Test
    public void UserRegister(){
      Response response =  Thing_GetItApi.RegisterUser();
        Assert.assertEquals(response.statusCode(), StatusCode.CODE_201.getCode());
        Assert.assertEquals(response.jsonPath().getString("data.user.firstName"), Data.firstName);
        Assert.assertEquals(response.jsonPath().getString("data.user.email"), Data.email);

    }
}
