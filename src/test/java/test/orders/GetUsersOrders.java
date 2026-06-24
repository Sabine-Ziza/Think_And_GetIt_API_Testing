package test.orders;

import base.Thing_GetItApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetUsersOrders {
    @Test
    public void getUserOrdersTest(){
        Response response = Thing_GetItApi.getUsersOrders();
        response.prettyPrint();
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        Assert.assertNotNull(response.jsonPath().getString("data[0].id"));
        Assert.assertNotNull(response.jsonPath().getString("data[0].orderNumber"));
        Assert.assertFalse(response.jsonPath().getList("data").isEmpty());

    }
}
