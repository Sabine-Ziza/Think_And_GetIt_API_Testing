package test.orders;

import base.Thing_GetItApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetSingleOrder {
    @Test
    public void getSingleOrderTest() {
        Response response = Thing_GetItApi.getSingleOrder();
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 404);
        Assert.assertFalse(response.jsonPath().getBoolean("success"));
        Assert.assertEquals(
                response.jsonPath().getString("message"),
                "Order not found");
    }
}
