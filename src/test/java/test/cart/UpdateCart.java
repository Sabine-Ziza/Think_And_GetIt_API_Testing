package test.cart;

import base.Thing_GetItApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateCart {
    @Test
    public void updateCartTest(){
        Response response = Thing_GetItApi.updateCart();
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        Assert.assertEquals(response.jsonPath().getString("message"), "Cart updated");
    }
}
