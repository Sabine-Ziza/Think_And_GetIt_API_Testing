package test.search;

import base.Thing_GetItApi;
import constant.StatusCode;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchWithFilterTest {
    @Test
    public void searchProductWithFilter(){
        Response response = Thing_GetItApi.searchProductWithFilter();
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), StatusCode.CODE_200.getCode());
        Assert.assertTrue(
                response.jsonPath().getList("data").size() > 0,
                "Search results should not be empty"
        );
    }
}
