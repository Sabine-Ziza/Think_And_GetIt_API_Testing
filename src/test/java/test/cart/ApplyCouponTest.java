package test.cart;

import base.Thing_GetItApi;
import constant.StatusCode;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApplyCouponTest {
    @Test
    public void applyCouponTest(){
        Response response = Thing_GetItApi.applyCoupon();
        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(), StatusCode.CODE_200.getCode());
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        Assert.assertEquals(
                response.jsonPath().getString("message"),
                "Coupon applied! You save 15%"
        );

    }

}
