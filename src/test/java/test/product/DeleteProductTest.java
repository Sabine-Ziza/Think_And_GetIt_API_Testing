package test.product;

import base.Thing_GetItApi;
import constant.StatusCode;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteProductTest {
    @Test
    public void deleteProductAsAdminTest() {
        Response response = Thing_GetItApi.deleteProductAsAdmin();
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), StatusCode.CODE_200.getCode());
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        Assert.assertEquals(response.jsonPath().getString("message"), "Product deactivated");
        Assert.assertNotNull(response.jsonPath().getMap("data"));
    }
}
