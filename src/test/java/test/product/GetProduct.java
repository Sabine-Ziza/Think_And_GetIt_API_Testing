package test.product;

import base.Thing_GetItApi;
import constant.StatusCode;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetProduct {
    @Test
    public void getProductTest() {

        Response response = Thing_GetItApi.getProduct(1, 20);
        response.prettyPrint();

        Assert.assertEquals(response.statusCode(), StatusCode.CODE_200.getCode());
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        Assert.assertEquals(response.jsonPath().getString("message"), "Success");

        Assert.assertFalse(response.jsonPath().getList("data").isEmpty());
        Assert.assertNotNull(response.jsonPath().getString("data[0].id"));
        Assert.assertNotNull(response.jsonPath().getString("data[0].name"));
        Assert.assertTrue(response.jsonPath().getDouble("data[0].price") > 0);

        Assert.assertEquals(response.jsonPath().getInt("pagination.page"), 1);
        Assert.assertEquals(response.jsonPath().getInt("pagination.limit"), 20);
    }
}
