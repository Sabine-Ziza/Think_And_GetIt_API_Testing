package test.admin;

import base.RestResource;
import base.Thing_GetItApi;
import constant.StatusCode;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class getAdminDashboardTest {
    @Test
    public void getAdminDashboardTest(){
        Response response = Thing_GetItApi.getAdminDashboard();
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), StatusCode.CODE_200.getCode());
        Assert.assertEquals(response.statusCode(), 200);

        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        Assert.assertEquals(response.jsonPath().getString("message"), "Success");

        Assert.assertTrue(response.jsonPath().getInt("data.stats.users.total") > 0);
        Assert.assertTrue(response.jsonPath().getInt("data.stats.users.newThisMonth") >= 0);

        Assert.assertTrue(response.jsonPath().getInt("data.stats.orders.total") > 0);
        Assert.assertTrue(response.jsonPath().getInt("data.stats.orders.thisMonth") >= 0);


        Assert.assertTrue(response.jsonPath().getFloat("data.stats.revenue.thisMonth") >= 0);
        Assert.assertTrue(response.jsonPath().getFloat("data.stats.revenue.lastMonth") >= 0);
        Assert.assertTrue(response.jsonPath().getFloat("data.stats.revenue.growth") >= 0);

        Assert.assertTrue(response.jsonPath().getInt("data.stats.products.total") > 0);
        Assert.assertTrue(response.jsonPath().getInt("data.stats.products.lowStock") >= 0);


        Assert.assertNotNull(response.jsonPath().get("data.ordersByStatus"));
        Assert.assertTrue(response.jsonPath().getInt("data.ordersByStatus.PENDING") >= 0);
        Assert.assertTrue(response.jsonPath().getInt("data.ordersByStatus.DELIVERED") >= 0);
        Assert.assertTrue(response.jsonPath().getInt("data.ordersByStatus.CONFIRMED") >= 0);
        Assert.assertTrue(response.jsonPath().getInt("data.ordersByStatus.SHIPPED") >= 0);
        Assert.assertTrue(response.jsonPath().getInt("data.ordersByStatus.CANCELLED") >= 0);
        Assert.assertTrue(response.jsonPath().getInt("data.ordersByStatus.RETURNED") >= 0);

        Assert.assertNotNull(response.jsonPath().getList("data.recentOrders"));
    }
}
