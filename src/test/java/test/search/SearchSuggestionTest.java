package test.search;

import base.Thing_GetItApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchSuggestionTest {
    @Test
    public void searchSuggestionTest(){
        Response response = Thing_GetItApi.getSearchSuggestions("je");
        response.prettyPrint();
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        Assert.assertEquals(response.jsonPath().getString("message"), "Success");
        Assert.assertFalse(response.jsonPath().getList("data").isEmpty());

        Assert.assertEquals(
                response.jsonPath().getString("data[0].type"),
                "product"
        );
    }

    @Test
    public void searchSuggestionNoMatchTest() {

        Response response = Thing_GetItApi.getSearchSuggestions("b");
        response.then().statusCode(200);
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        Assert.assertEquals(response.jsonPath().getString("message"), "Success");
        Assert.assertTrue(
                response.jsonPath().getList("data").isEmpty(),
                "Expected no suggestions to be returned"
        );
    }
}
