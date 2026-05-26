package base;

import io.restassured.response.Response;
import org.testng.SuiteRunnerWorker;
import payload.ForgotPojo;
import payload.LoginRequest;
import payload.register.RegisterPOJO;
import routes.Route;

import java.util.Map;


public class Thing_GetItApi {
    public static Response login() {
        LoginRequest payload = new LoginRequest();
        payload.setEmail(Data.loginEmail);
        payload.setPassword(Data.loginPassword);

        return RestResource.post(Route.LOGIN, payload);

    }

    public static Response getCurrentUser() {
        String token = login().jsonPath().getString("data.token");
        return RestResource.getCurrentUser(Route.CURRENT_USER, token);
    }

    public static Response RegisterUser() {
        RegisterPOJO requestBody = new RegisterPOJO();
        requestBody.setEmail(Data.email);
        requestBody.setFirstName(Data.firstName);
        requestBody.setLastName(Data.lastName);
        requestBody.setPassword(Data.password);
        return RestResource.post(Route.CREATE_USER, requestBody);
    }

    public static Response registerAndVerifyEmail() {
        String token = login().jsonPath().getString("data.token");
        String path = Route.VERIFY_EMAIL + token;
        return RestResource.get(path);

    }

    public static Response forgotPassword() {
        ForgotPojo request = new ForgotPojo();
        request.setEmail(Data.email);
        return RestResource.post(Route.FORGOT_EMAIL, request);

    }

    public static Response ResetPassword() {
        ForgotPojo reset = new ForgotPojo();
        reset.setEmail(Data.email);
        reset.setNewPassword(Data.newPassword);
        return RestResource.post(Route.FORGOT_EMAIL, reset);
    }

    public static Response RefreshToken() {
        String token = login().jsonPath().getString("data.refreshToken");
        return RestResource.post(Route.REFRESH_TOKEN, Map.of("refreshToken", token));
    }

}