package test.reviews;

import base.Thing_GetItApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubmitReviews {
    @Test
    public void submitReviewTest() {
        Response response = Thing_GetItApi.submitReviews();
        response.prettyPrint();
        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(), 201);

        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        Assert.assertEquals(response.jsonPath().getString("message"), "Review submitted");





    }
}
