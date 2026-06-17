package test.product;

import base.Thing_GetItApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetSingleProductTest {
    @Test
    public void getSingleProductTest(){
        Response response = Thing_GetItApi.getSingleProductBySlug();
        response.prettyPrint();

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        Assert.assertEquals(response.jsonPath().getString("message"), "Success");
        String actualSlug = response.jsonPath().getString("data.slug");
        Assert.assertNotNull(actualSlug);


    }
}
