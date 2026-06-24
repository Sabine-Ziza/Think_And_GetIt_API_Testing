package test.product;

import base.Thing_GetItApi;
import constant.StatusCode;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TrendingProductTest {
    @Test
    public void getTrendingProductTest(){
        Response response = Thing_GetItApi.getTrendingProduct();
        response.prettyPrint();

        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        Assert.assertTrue(response.jsonPath().getList("data").size() > 0);
        Assert.assertEquals(response.statusCode(), StatusCode.CODE_200.getCode());

    }
}
