package test.cart;

import base.Thing_GetItApi;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ClearEntireCart {
    @Test
      public void deleteCartTest(){
        Response response = Thing_GetItApi.deleteCartItem();
        response.prettyPrint();
        System.out.println(response.asPrettyString());
    }




}
