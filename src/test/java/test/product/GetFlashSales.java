package test.product;

import base.Thing_GetItApi;
import constant.StatusCode;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetFlashSales {
    @Test
    public void getFlashSalesTest(){
        Response response = Thing_GetItApi.getFlashSales();
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), StatusCode.CODE_200.getCode());
        Assert.assertFalse(response.getBody().asString().isEmpty());

    }
}
