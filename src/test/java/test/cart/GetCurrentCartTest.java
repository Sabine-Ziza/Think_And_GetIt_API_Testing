package test.cart;

import base.Thing_GetItApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetCurrentCartTest {
    @Test
    public void getCartTest(){
        Response response = Thing_GetItApi.getCartProduct();
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.jsonPath().getList("data.items").isEmpty());

    }


}
