package test.categories;

import base.Thing_GetItApi;
import constant.StatusCode;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateCategoryTest {
    @Test
    public void createCategoryAsCustomerShouldFail(){
        Response response = Thing_GetItApi.CreateCategoryAsCustomer();
        response.prettyPrint();
            Assert.assertEquals(response.statusCode(), StatusCode.CODE_403.getCode());
            Assert.assertFalse(response.jsonPath().getBoolean("success"));
            Assert.assertEquals(
                    response.jsonPath().getString("message"),
                    "You do not have permission for this action");

    }

    @Test
    public void createCategoryAsAdmin(){
        Response response = Thing_GetItApi.CreateCategoryAsAdmin();
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), StatusCode.CODE_201.getCode());
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        Assert.assertEquals(
                response.jsonPath().getString("message"),
                "Category created");

    }
}
