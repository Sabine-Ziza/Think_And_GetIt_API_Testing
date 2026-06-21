package test.product;

import base.Thing_GetItApi;
import constant.StatusCode;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadProductImageTest {
    @Test
    public void uploadProductImagesAsAdminTest() {

        Response response = Thing_GetItApi.uploadProductImageAdmin();

        response.prettyPrint();

        Assert.assertEquals(response.statusCode(), StatusCode.CODE_201.getCode());

        Assert.assertTrue(response.jsonPath().getBoolean("success"));

        Assert.assertEquals(response.jsonPath().getString("message"), "Images uploaded");
    }
}
