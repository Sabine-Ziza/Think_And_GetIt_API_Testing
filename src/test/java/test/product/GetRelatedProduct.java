package test.product;

import base.Thing_GetItApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetRelatedProduct {
    @Test
    public void getRelatedProductTest(){
        Response response = Thing_GetItApi.getRelatedProduct();
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        Assert.assertNotNull(response.jsonPath().getList("data"));
        Assert.assertTrue(response.jsonPath().getList("data").size() > 0);
    }
}
