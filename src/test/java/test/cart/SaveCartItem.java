package test.cart;

import base.Thing_GetItApi;
import constant.StatusCode;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SaveCartItem {
    @Test
    public void saveCartItemTest(){
        Response response = Thing_GetItApi.saveItemForLater();
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), StatusCode.CODE_200.getCode());
        Assert.assertEquals(response.jsonPath().getString("message"), "Saved for later");
    }
}
