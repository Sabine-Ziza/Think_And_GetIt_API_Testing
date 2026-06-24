package test.orders;

import base.Thing_GetItApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

public class CancelOrderTest {
    @Test
    public void cancelTest(){
        Response response = Thing_GetItApi.CancelOrder();
        Thing_GetItApi.addProductToCart();
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("message"), "Order cancelled");
    }
}
