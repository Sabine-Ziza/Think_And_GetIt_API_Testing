package test.product;

import base.Thing_GetItApi;
import constant.StatusCode;
import groovyjarjarantlr4.v4.codegen.model.SrcOp;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateProductAsAdmin {
    @Test
    public void updateProductTest() {
        Response response = Thing_GetItApi.updateProduct();
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), StatusCode.CODE_200.getCode());
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        Assert.assertEquals(response.jsonPath().getString("message"), "Product updated");
    }
}
