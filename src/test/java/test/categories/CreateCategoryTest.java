package test.categories;

import base.Thing_GetItApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateCategoryTest {
    @Test
    public void createCategoryAsCustomerShouldFail() {
        Response response = Thing_GetItApi.CreateCategoryAsCustomer();
        response.prettyPrint();


        Assert.assertEquals(response.statusCode(), 403); // if backend uses 403
        Assert.assertFalse(response.jsonPath().getBoolean("success"));
        Assert.assertEquals(
                response.jsonPath().getString("message"),
                "You do not have permission for this action");

    }
}
