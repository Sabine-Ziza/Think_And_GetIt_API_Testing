package test;

import base.Thing_GetItApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReviewsTest {
    @Test
    public void getReviewsTest(){
        Response response = Thing_GetItApi.getReviews();
        response.prettyPrint();

        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        Assert.assertEquals(response.jsonPath().getString("message"), "Success");
        Assert.assertEquals(response.jsonPath().getDouble("pagination.averageRating"), 0.0);
        Assert.assertEquals(response.jsonPath().getInt("pagination.totalReviews"), 0);
    }

}
