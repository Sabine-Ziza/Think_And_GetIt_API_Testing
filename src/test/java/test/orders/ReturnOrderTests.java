package test.orders;

import base.Thing_GetItApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReturnOrderTests {
    @Test
    public void returnOrder(){
        Response response = Thing_GetItApi.returnOrder();
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 400);
        Assert.assertFalse(response.jsonPath().getBoolean("success"));
        Assert.assertEquals(response.jsonPath().getString("message"),
                "Only delivered orders can be returned");
    }
}
