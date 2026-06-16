package test.cart;

import base.Thing_GetItApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductToCart {
    @Test
    public void addProductToCart() {
        Response response = Thing_GetItApi.addProductToCart();
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        Assert.assertEquals(response.jsonPath().getString("message"), "Item added to cart");
        Assert.assertNotNull(response.jsonPath().get("data"));
    }
}
