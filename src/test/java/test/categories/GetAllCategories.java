package test.categories;

import base.Thing_GetItApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetAllCategories {
    @Test
    public void AllCategoriesTest(){
        Response response =Thing_GetItApi.getAllCategories();
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertNotNull(response.jsonPath().getList("data"));
        Assert.assertFalse(response.jsonPath().getList("data").isEmpty());

    }


}
