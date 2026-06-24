package test.orders;

import base.Data;
import base.Thing_GetItApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static base.Thing_GetItApi.*;

public class UpdateOrderStatusTest {
    @Test
    public void updateOrderStatusTest() {
        String orderId = getSingleOrder().jsonPath().getString("data.id");
        Response response = Thing_GetItApi.updateOrderStatus(orderId, Data.STATUS_CONFIRMED);
        addProductToCart();
        placeOrders();
        response.prettyPrint();
        response.then().statusCode(200);

        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        Assert.assertEquals(response.jsonPath().getString("message"),
                "Order status updated");

        Assert.assertNotNull(response.jsonPath().getString("data.id"));

        Assert.assertEquals(response.jsonPath().getString("data.status"),
                Data.STATUS_CONFIRMED);
    }
}
