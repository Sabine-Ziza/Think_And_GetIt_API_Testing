package test.userManagement;

import base.Thing_GetItApi;
import constant.StatusCode;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static base.Thing_GetItApi.login;

public class GetUserAddresses {
    @Test
    public void getUserAddressTest(){
        Response getUserRequest = Thing_GetItApi.getUserAddress();

        System.out.println(getUserRequest.asPrettyString());
        String address = getUserRequest.jsonPath().getString("data.address");
        System.out.println(address);
        Assert.assertEquals(getUserRequest.statusCode(), StatusCode.CODE_200.getCode());
    }
}
