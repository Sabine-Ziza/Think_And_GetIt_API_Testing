package test.cart;

import base.Thing_GetItApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApplyCouponTest {
    @Test
    public void applyCouponTest(){
        Response response = Thing_GetItApi.applyCoupon();
        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(), 400);
        Assert.assertFalse(response.jsonPath().getBoolean("success"));
        Assert.assertEquals(
                response.jsonPath().getString("message"),
                "Invalid or expired coupon code"
        );

    }

}
