package test.categories;

import base.Thing_GetItApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetSingleCategories {
    @Test
    public void getSingleCategoryTest(){
        Response response = Thing_GetItApi.getSingleCategorySlug();
        response.prettyPrint();
        Assert.assertNotNull(response.jsonPath().getString("data.name"));
        Assert.assertNotNull(response.jsonPath().getString("data.slug"));
        Assert.assertNotNull(response.jsonPath().getString("data.id"));
    }

}
