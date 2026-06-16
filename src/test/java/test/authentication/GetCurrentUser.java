package test.authentication;

import base.Thing_GetItApi;
import org.testng.annotations.Test;


public class GetCurrentUser {

    @Test
    public void getCurrentUserTest(){
        Thing_GetItApi.getCurrentUser();

    }
}
