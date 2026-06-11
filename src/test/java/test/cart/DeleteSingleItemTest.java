package test.cart;

import base.Thing_GetItApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteSingleItemTest {
    @Test
    public void deleteSingleItemTest(){
        Response response = Thing_GetItApi.deleteSingleItem();
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("message"), "Item removed");
        Assert.assertTrue(response.jsonPath().getBoolean("success"));


    }
}
