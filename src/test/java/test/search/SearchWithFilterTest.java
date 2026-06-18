package test.search;

import base.Thing_GetItApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchWithFilterTest {
    @Test
    public void searchProductWithFilter(){
        Response response = Thing_GetItApi.searchProductWithFilter();
        response.prettyPrint();
        Assert.assertTrue(
                response.jsonPath().getList("data").size() > 0,
                "Search results should not be empty"
        );
    }
}
