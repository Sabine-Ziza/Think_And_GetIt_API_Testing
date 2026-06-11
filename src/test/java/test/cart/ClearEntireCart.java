package test.cart;

import base.Thing_GetItApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClearEntireCart {
    @Test
      public void deleteCartTest(){
        Response response = Thing_GetItApi.deleteCartItem();
        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        Assert.assertEquals(
                response.jsonPath().getString("message"),
                "Cart cleared"
        );
        Assert.assertNotNull(response.jsonPath().get("data"));
        System.out.println(response.asPrettyString());
    }




}
