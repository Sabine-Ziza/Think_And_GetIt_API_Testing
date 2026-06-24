package test.wishlists;

import base.Thing_GetItApi;
import constant.StatusCode;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.IDynamicGraph;
import org.testng.annotations.Test;

public class getWishlistTest {
    @Test
    public void  wishlistTest(){
        Response response = Thing_GetItApi.getWishlist();
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), StatusCode.CODE_200.getCode());
    }

}
