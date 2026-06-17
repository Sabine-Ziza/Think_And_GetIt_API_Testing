package test.product;

import base.Thing_GetItApi;
import constant.StatusCode;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateProductTest {
    @Test
    public void createProductTest() {
        Response response = Thing_GetItApi.createProduct();
        response.prettyPrint();

        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), StatusCode.CODE_201.getCode());
        Assert.assertTrue(response.jsonPath().getBoolean("success"));

        Assert.assertEquals(response.jsonPath().getString("message"), "Product created");
        Assert.assertNotNull(response.jsonPath().getString("data.id"));
        Assert.assertTrue(response.jsonPath().getBoolean("data.isActive"));
        Assert.assertNotNull(response.jsonPath().getString("data.inventory.id"));

    }
}


