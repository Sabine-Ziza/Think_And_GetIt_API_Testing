package test.admin;

import base.Thing_GetItApi;
import constant.StatusCode;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateCouponTest {
    @Test
    public void CreateCouponAsAdminTest() {
        Response response = Thing_GetItApi.CreateCoupon();
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), StatusCode.CODE_201.getCode());

// Success
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        Assert.assertEquals(response.jsonPath().getString("message"), "Coupon created");
        Assert.assertNotNull(response.jsonPath().getString("data.id"));
        Assert.assertNotNull(response.jsonPath().getString("data.code"));
        Assert.assertEquals(response.jsonPath().getString("data.description"), "50% discount coupon");
        Assert.assertEquals(response.jsonPath().getString("data.discountType"), "PERCENTAGE");
        Assert.assertEquals(response.jsonPath().getInt("data.discountValue"), 50);
        Assert.assertEquals(response.jsonPath().getInt("data.minOrderAmount"), 200);
        Assert.assertEquals(response.jsonPath().getInt("data.maxUses"), 70);
        Assert.assertEquals(response.jsonPath().getInt("data.usedCount"), 0);
        Assert.assertTrue(response.jsonPath().getBoolean("data.isActive"));
        Assert.assertNotNull(response.jsonPath().getString("data.expiresAt"));
        Assert.assertNotNull(response.jsonPath().getString("data.createdAt"));
    }
}
