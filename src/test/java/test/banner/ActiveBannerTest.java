package test.banner;

import base.Thing_GetItApi;
import constant.StatusCode;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActiveBannerTest {
    @Test
    public void getActiveBannerTest(){
        Response response = Thing_GetItApi.getActiveBanner();
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), StatusCode.CODE_200.getCode());
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        Assert.assertEquals(response.jsonPath().getString("message"), "Success");
        Assert.assertTrue(response.jsonPath().getList("data").size() > 0);
        Assert.assertTrue(response.jsonPath().getBoolean("data[0].isActive")
        );
    }

}
