package test.orders;

import base.Thing_GetItApi;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetUsersOrders {
    @Test
    public void getUserOrdersTest(){
        Response response = Thing_GetItApi.getUsersOrders();
        response.prettyPrint();

    }
}
