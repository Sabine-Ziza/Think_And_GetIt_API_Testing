package test.wishlists;

import base.Thing_GetItApi;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class AddWishListToCartTest {
    @Test
    public void addWishlistToCartTest(){
        Response response = Thing_GetItApi.addWishlistToCart();
        response.prettyPrint();
    }
}
