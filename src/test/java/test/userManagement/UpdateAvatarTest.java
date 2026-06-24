package test.userManagement;

import base.Thing_GetItApi;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class UpdateAvatarTest {
    @Test
    public void testUpdateAvatar(){
        Response response = Thing_GetItApi.updateAvatar();
        response.prettyPrint();
    }

}
