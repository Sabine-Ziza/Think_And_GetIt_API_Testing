package test.wishlists;

import base.Thing_GetItApi;
import constant.StatusCode;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetWishlistTest {
    @Test
    public void  getWishlistTest(){
        Response response = Thing_GetItApi.getWishlist();
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), StatusCode.CODE_200.getCode());
    }

}
