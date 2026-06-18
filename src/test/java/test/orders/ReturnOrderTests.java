package test.orders;

import base.Thing_GetItApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static base.Thing_GetItApi.getSingleOrder;

public class ReturnOrderTests {
    @Test
    public void returnOrder(){

        String orderId = getSingleOrder().jsonPath().getString("data.items[0].orderId");

        Response response = Thing_GetItApi.returnOrder(orderId);
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 400);
        Assert.assertFalse(response.jsonPath().getBoolean("success"));
        Assert.assertEquals(response.jsonPath().getString("message"),
                "Only delivered orders can be returned");
    }

    @Test
    public void getReturnOrder(){
        String orderId = Thing_GetItApi.getNonDeliveredOrder();
        Response response = Thing_GetItApi.returnOrder(orderId);
        response.prettyPrint();
    }
}
