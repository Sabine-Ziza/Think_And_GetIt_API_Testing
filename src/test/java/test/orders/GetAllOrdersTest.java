package test.orders;

import base.Thing_GetItApi;
import constant.StatusCode;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetAllOrdersTest {
    @Test
    public void getAllOrderTest(){
        Response response = Thing_GetItApi.getAllOrders();
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), StatusCode.CODE_200.getCode());
        Assert.assertNotNull(response.getBody());
        Assert.assertFalse(response.asString().isEmpty());
    }
}
