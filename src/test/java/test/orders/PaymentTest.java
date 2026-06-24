package test.orders;

import base.Thing_GetItApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PaymentTest {
    @Test
    public void getPaymentTest(){
        Response response = Thing_GetItApi.paymentProof();
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), 200);

        Assert.assertTrue(
                response.jsonPath().getBoolean("success"),
                "Success should be true"
        );

        Assert.assertEquals(
                response.jsonPath().getString("message"),
                "Payment proof uploaded. We will verify and confirm your order."
        );

        Assert.assertNotNull(
                response.jsonPath().get("data"),
                "Data should not be null"
        );
    }

}
