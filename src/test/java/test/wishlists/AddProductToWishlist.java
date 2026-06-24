package test.wishlists;

import base.Thing_GetItApi;
import constant.StatusCode;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductToWishlist {
    @Test
    public void addProductToWishlistTest(){
        Response response = Thing_GetItApi.addProductToWishlist();
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), StatusCode.CODE_201.getCode());
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        Assert.assertEquals(response.jsonPath().getString("message"), "Added to wishlist");
    }

    @Test
    public void addProductAlreadyInWishlistTest() {

        Response response = Thing_GetItApi.addProductToWishlist();

        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(), 409);
        Assert.assertFalse(response.jsonPath().getBoolean("success"));
        Assert.assertEquals(
                response.jsonPath().getString("message"),
                "Already in wishlist"
        );
    }
}
