package test.search;

import base.Thing_GetItApi;
import constant.StatusCode;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GetTrendingSearchTest {
    @Test
    public void getTrendingSearchesTest() {

        Response response = Thing_GetItApi.getTrendingSearch();
         response.prettyPrint();
        Assert.assertEquals(response.statusCode(), StatusCode.CODE_200.getCode());
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        Assert.assertEquals(response.jsonPath().getString("message"), "Success");
        Assert.assertNotNull(response.jsonPath().get("data"));
        List<String> trendingSearches = response.jsonPath().getList("data");

        Assert.assertNotNull(trendingSearches);

        Assert.assertFalse(
                trendingSearches.isEmpty(),
                "Trending searches should not be empty"
        );
    }
}
