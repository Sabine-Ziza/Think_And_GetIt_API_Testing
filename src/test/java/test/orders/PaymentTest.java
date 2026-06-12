package test.orders;

import base.Thing_GetItApi;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class PaymentTest {
    @Test
    public void getPaymentTest(){
        Response response = Thing_GetItApi.paymentProof();
        response.prettyPrint();
    }

}
