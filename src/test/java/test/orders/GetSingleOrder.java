package test.orders;

import base.Data;
import base.Thing_GetItApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetSingleOrder {
    @Test
    public void getSingleOrderTest() {
        Response response = Thing_GetItApi.getSingleOrder();
        Thing_GetItApi.addProductToCart();
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        Assert.assertEquals(
                response.jsonPath().getString("message"),
                "Success");
    }
}
