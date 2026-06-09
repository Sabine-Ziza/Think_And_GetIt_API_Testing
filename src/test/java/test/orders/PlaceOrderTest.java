package test.orders;

import base.Thing_GetItApi;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class PlaceOrderTest {
    @Test
    public void placeOrderTest(){
        Response response = Thing_GetItApi.placeOrders();
        response.prettyPrint();
    }
}
