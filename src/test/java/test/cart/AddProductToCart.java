package test.cart;

import base.Thing_GetItApi;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class AddProductToCart {
    @Test
    public void addProductToCart(){
        Response response = Thing_GetItApi.addProductToCart();
        response.prettyPrint();
    }
}
