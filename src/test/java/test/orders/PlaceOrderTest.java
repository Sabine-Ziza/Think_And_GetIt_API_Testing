package test.orders;

import base.Thing_GetItApi;
import constant.StatusCode;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaceOrderTest {
    @Test
    public void placeOrderTest(){
        Response response = Thing_GetItApi.placeOrders();
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), StatusCode.CODE_201.getCode());
        Assert.assertEquals(response.jsonPath().getString("message"),"Order placed successfully");
    }
}
