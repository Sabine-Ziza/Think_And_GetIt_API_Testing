package test.orders;

import base.Thing_GetItApi;
import constant.StatusCode;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


import static base.Thing_GetItApi.addProductToCart;

public class PlaceOrderTest {
    @Test
    public void placeOrderTest(){
        Thing_GetItApi.addProductToCart();
        Response response = Thing_GetItApi.placeOrders();
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), StatusCode.CODE_201.getCode());
        Assert.assertEquals(response.jsonPath().getString("message"),"Order placed successfully");
    }
}
