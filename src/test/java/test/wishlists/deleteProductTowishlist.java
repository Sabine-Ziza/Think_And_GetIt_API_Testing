package test.wishlists;

import base.Thing_GetItApi;
import constant.StatusCode;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class deleteProductTowishlist {
    @Test
    public void deleteWishlistTest(){
        Response response = Thing_GetItApi.deleteProductToWishlist();
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), StatusCode.CODE_200.getCode());
        Assert.assertEquals(response.jsonPath().getString("message"), "Removed from wishlist");
    }
}
