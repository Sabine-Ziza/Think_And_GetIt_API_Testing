package test.userManagement;

import base.Thing_GetItApi;
import constant.StatusCode;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import routes.Route;

public class AddUserAddress {
    @Test
    public void addUserAddresses(){
        Response addressRequest = Thing_GetItApi.addNewAddress();
        System.out.println(addressRequest);
        addressRequest.prettyPrint();
        Assert.assertEquals(addressRequest.statusCode(), StatusCode.CODE_201.getCode());
        Assert.assertEquals(
                addressRequest.jsonPath().getString("message"),
                "Address added"
        );
    }
}
