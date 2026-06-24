package test.product;

import base.Thing_GetItApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateProduct {
    @Test
    public void createProductTest(){
        Response response = Thing_GetItApi.createProduct();
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), 201);
    }

}
