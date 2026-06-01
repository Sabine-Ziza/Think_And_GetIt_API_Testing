package base;

import io.restassured.response.Response;
import org.mozilla.javascript.Token;
import payload.ChangePasswordPojo;
import payload.ForgotPojo;
import payload.LoginRequest;
import payload.register.AddressPojo;
import payload.register.RegisterPOJO;
import routes.Route;

import java.io.File;
import java.util.Map;

import static base.Data.avatarPath;
import static base.Data.currentPassword;


public class Thing_GetItApi {

//    private static String activePassword = currentPassword;
    public static Response login() {
        LoginRequest payload = new LoginRequest();
        payload.setEmail(Data.loginEmail);
        payload.setPassword(Data.currentPassword);
        System.out.println(payload);
        System.out.println(payload.getEmail());
        System.out.println(payload.getPassword());

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
        requestBody.setPassword(currentPassword);
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
    public static Response getUserAddress(){
        String response = login().jsonPath().getString("data.token");
        return RestResource.getCurrentUser(Route.USER_ADDRESS, response);
    }
    public static Response addNewAddress(){
        AddressPojo addressRequest = new AddressPojo();
        String token = login().jsonPath().getString("data.token");
        System.out.println("Token: " + token);
        System.out.println("Request going to: " + Route.NEW_ADDRESS);

        addressRequest.setAddress(Data.address);
        addressRequest.setFirstName(Data.firstName);
        addressRequest.setLastName(Data.lastName);
        addressRequest.setPhone(Data.phone);
        addressRequest.setEmail(Data.email);
        addressRequest.setStreet(Data.street);
        addressRequest.setCity(Data.city);
        addressRequest.setPassword(currentPassword);
        addressRequest.setState(Data.state);
        addressRequest.setCountry(Data.country);
        addressRequest.setPostalCode(Data.postalCode);
        addressRequest.setUserId(Data.userId);
        addressRequest.setLabel(Data.label);
        addressRequest.setLabel(Data.isDefault);
        System.out.println(addressRequest);
        return RestResource.addAddress(Route.NEW_ADDRESS, token, addressRequest);
    }
    public static Response getChangePassword(){
        ChangePasswordPojo passwordPojo = new ChangePasswordPojo();
        String token = login().jsonPath().getString("data.token");
        passwordPojo.setCurrentPassword(currentPassword);
        passwordPojo.setNewPassword(Data.newPassword);

        return RestResource.changePasswords(Route.CHANGE_PASSWORD, token, passwordPojo);

    }
    public static Response updateAvatar(){
        System.out.println(">>> updateAvatar STARTED");

        Response loginResponse = login();

        System.out.println("LOGIN RESPONSE:");
        System.out.println(loginResponse.asPrettyString());

        String token = loginResponse.jsonPath().getString("data.token");
        if (token == null || token.isEmpty()) {
            throw new RuntimeException("Token is null - login failed");
        }


            System.out.println("TOKEN = " + token);

        File file = new File(Data.avatarPath);
        System.out.println(file.exists());
        System.out.println(file.length());

        return RestResource.put(Route.AVATAR_LINK, token, file);
    }
    public static Response updateProfile(){
        String token = login().jsonPath().getString("data.token");
        RegisterPOJO registerPOJO = new RegisterPOJO();
        registerPOJO.setPassword(Data.currentPassword);
        registerPOJO.setEmail(Data.email);
        registerPOJO.setFirstName(Data.firstName);
        registerPOJO.setLastName(Data.lastName);
        registerPOJO.setPhone(Data.phone);
        return RestResource.updateProfile(Route.UPDATE_PROFILE, token, registerPOJO);



    }
    public static Response getAllCategories(){
        return RestResource.get(Route.CATEGORIES);
    }

}