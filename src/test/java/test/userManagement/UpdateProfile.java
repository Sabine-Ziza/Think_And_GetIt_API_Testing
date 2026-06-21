package test.userManagement;

import base.Thing_GetItApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateProfile {
    @Test
    public void updateProfileTest(){
        Response response = Thing_GetItApi.updateProfile();
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        Assert.assertEquals(response.jsonPath().getString("message"), "Profile updated");

    }
}
