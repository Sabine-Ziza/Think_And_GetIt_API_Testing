package base;

import io.restassured.response.Response;
import org.yaml.snakeyaml.events.Event;
import payload.*;
import payload.register.RegisterPOJO;
import routes.Route;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static base.Data.currentPassword;
import static base.Data.productCategoryId;


public class Thing_GetItApi {

    public static Response login() {
        LoginRequest payload = new LoginRequest();
        payload.setEmail(Data.AdminloginEmail);
        payload.setPassword(Data.AdminPassword);
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

    public static Response getUserAddress() {
        String response = login().jsonPath().getString("data.token");
        return RestResource.getCurrentUser(Route.USER_ADDRESS, response);
    }

    public static Response addNewAddress() {

        String token = login().jsonPath().getString("data.token");

        Map<String, Object> body = new HashMap<>();

        body.put("firstName", "sab1780997261737");
        body.put("lastName", "ziz1780997261737");

        body.put("street", "kk448");
        body.put("city", "kayonza");
        body.put("state", "mombasa");
        body.put("country", "Rwanda");
        body.put("postalCode", "123456");
        body.put("phone", "078943322");

        body.put("userId", "d0a82fb0-830f-4800-b855-011e7211d458" + System.currentTimeMillis());
        body.put("label", "home");
        body.put("isDefault", false);

        System.out.println(body);

        return RestResource.addAddress(Route.NEW_ADDRESS, token, body);
    }

    public static Response getChangePassword() {
        ChangePasswordPojo passwordPojo = new ChangePasswordPojo();
        String token = login().jsonPath().getString("data.token");
        passwordPojo.setCurrentPassword(currentPassword);
        passwordPojo.setNewPassword(Data.newPassword);

        return RestResource.changePasswords(Route.CHANGE_PASSWORD, token, passwordPojo);

    }

    public static Response updateAvatar() {
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

        return RestResource.postAvatar(Route.AVATAR_LINK, token, file);
    }

    public static Response updateProfile() {
        String token = login().jsonPath().getString("data.token");
        RegisterPOJO registerPOJO = new RegisterPOJO();
        registerPOJO.setPassword(Data.currentPassword);
        registerPOJO.setEmail(Data.email);
        registerPOJO.setFirstName(Data.firstName);
        registerPOJO.setLastName(Data.lastName);
        registerPOJO.setPhone(Data.phone);
        return RestResource.updateProfile(Route.UPDATE_PROFILE, token, registerPOJO);


    }

    public static Response getAllCategories() {
        return RestResource.get(Route.CATEGORIES);
    }

    public static Response CreateCategoryAsCustomer() {
        String token = login().jsonPath().getString("data.token");
        CategoryPojo categoryPojo = new CategoryPojo();
        categoryPojo.setDescription(Data.categoryDescription);
        categoryPojo.setName(Data.categoryName);
        categoryPojo.setParentId(Data.categoryParentId);
        return RestResource.updateProfile(Route.CATEGORIES, token, categoryPojo);
    }

    public static Response getSingleCategorySlug() {
        String slug = getAllCategories().jsonPath().getString("data[1].slug");
        String path = Route.SINGLE_CATEGORIES + slug;
        System.out.println(slug);
        return RestResource.get(path);

    }

    public static Response getProduct(int i, int i1) {
        return RestResource.get(Route.PRODUCT);
    }

    public static Response createProduct() {
        String token = login().jsonPath().getString("data.token");
        String id = login().jsonPath().getString("data.id");
        ProductPojo productPojo = new ProductPojo();

        productPojo.setName(Data.productName);
        productPojo.setDescription(Data.productDescription);
        productPojo.setCategoryId(Data.productCategoryId);
        System.out.println("ID being sent: " + productCategoryId);
        productPojo.setPrice(Data.productPrice);
        productPojo.setComparePrice(Data.productComparePrice);

        return RestResource.postProduct(Route.PRODUCT, token, productPojo);

    }

    public static Response getSingleProductBySlug() {
        String slug = getProduct(1, 2).jsonPath().getString("data[0].slug");
        return RestResource.get(Route.SINGLE_PRODUCT + slug);
    }

    public static Response getTrendingProduct() {
        return RestResource.get(Route.TRANDING_PRODUCT);
    }

    public static Response getFlashSales() {
        return RestResource.get(Route.FLASH_SALES);
    }

    public static Response getRelatedProduct() {
        String token = login().jsonPath().getString("data.token");
        String id = getSingleProductBySlug().jsonPath().getString("data.id");
        String path = Route.RELATED_PRODUCT + id + Route.RELATED_PRODUCT_SUFFIX;
        return RestResource.getCurrentUser(path, token);
    }

    public static Response getCartProduct() {
        String token = login().jsonPath().getString("data.token");

        return RestResource.getCurrentUser(Route.CART, token);
    }

    public static Response addProductToCart() {
        String token = login().jsonPath().getString("data.token");
        String productId = getCartProduct().jsonPath().getString("data.items.productId");
        CartPojo cartPojo = new CartPojo();
        cartPojo.setProductId(Data.productId);
        cartPojo.setQuantity(Data.quantity);
        cartPojo.setVariantId(Data.variantsId);
        return RestResource.postProduct(Route.ADD_CART, token, cartPojo);
    }

    public static Response deleteCartItem() {
        String token = login().jsonPath().getString("data.token");

        return RestResource.delete(Route.CART, token);
    }

    public static Response updateCart() {
        String token = login().jsonPath().getString("data.token");
        String cartItem = getCartProduct().jsonPath().getString("data.items[0].id");
        CartPojo cartPojo = new CartPojo();
        cartPojo.setQuantity(Data.quantity + 1);

        String id = Route.UPDATE_CART + cartItem;
        return RestResource.updateProfile(id, token, cartPojo);
    }

    public static Response deleteSingleItem() {
        String token = login().jsonPath().getString("data.token");
        String itemId = getCartProduct().jsonPath().getString("data.items[0].id");
        System.out.println("Item ID: " + itemId);

        String path = Route.DELETE_SINGLE_ITEM + itemId;
        return RestResource.delete(path, token);

    }

    public static Response getUsersOrders() {
        String token = login().jsonPath().getString("data.token");
        return RestResource.getCurrentUser(Route.ORDERS, token);


    }

    public static Response placeOrders() {
        String token = login().jsonPath().getString("data.token");
        Response addressResponse = addNewAddress();
        String addressId = addressResponse.jsonPath().getString("data.id");

        OrderPojo order = new OrderPojo();
        order.setAddressId(addressId);
        order.setPaymentMethod(Data.paymentMethod);
        order.setNotes("Test Order");
        order.setShippingFee(0);
        return RestResource.addAddress(Route.ORDERS, token, order);
    }

    public static Response getSingleOrder() {

        String token = login().jsonPath().getString("data.token");
        Response orderResponse = placeOrders();
        orderResponse.prettyPrint();
        String ordersId = orderResponse.jsonPath().getString("data.id");
        String id = Route.SINGLE_ORDER + ordersId;
        System.out.println("Order ID = " + ordersId);
        return RestResource.getCurrentUser(id, token);


    }

    public static Response saveItemForLater() {
        String token = login().jsonPath().getString("data.token");
        String itemId = getCartProduct().jsonPath().getString("data.items[0].id");
        String path = Route.SAVE_ITEM + itemId + "/save-for-later";
        return RestResource.patch(path, token);

    }

    public static Response applyCoupon() {

        String token = login().jsonPath().getString("data.token");
        CouponPojo couponPojo = new CouponPojo();
        couponPojo.setCode(Data.couponCode);
        System.out.println(Route.COUPON);
        return RestResource.postProduct(Route.COUPON, token, couponPojo);


    }

    public static Response CancelOrder() {
        String token = login().jsonPath().getString("data.token");
        String orderId = getSingleOrder().jsonPath().getString("data.items[0].orderId");
        String path = Route.CANCEL_ORDER + orderId + "/cancel";
        return RestResource.patch(path, token);
    }

    public static Response returnOrder() {
        String token = login().jsonPath().getString("data.token");
        String orderId = getSingleOrder().jsonPath().getString("data.items[0].orderId");
        String path = Route.RETURN_ORDERS + orderId + "/return";
        OrderPojo orderPojo = new OrderPojo();
        orderPojo.setReason(Data.reason);
        return RestResource.patch(path, token);
    }

    public static Response paymentProof() {
        String token = login().jsonPath().getString("data.token");
        String orderId = getSingleOrder().jsonPath().getString("data.id");
        String path = Route.PAYMENT + orderId + "/payment-proof";
        File file = new File(Data.proofPath);
        return RestResource.postproof(path, token, file);

    }
    public static Response getAllOrders(){
        String token = login().jsonPath().getString("data.token");
        return RestResource.getCurrentUser(Route.ALL_ORDERS, token);
    }
    public static Response updateOrderStatus() {
        String token = login().jsonPath().getString("data.token");
        String orderId = getSingleOrder().jsonPath().getString("data.id");

       updateOrderStatusPojo updateOrderStatusPojo = new updateOrderStatusPojo();
       updateOrderStatusPojo.setMessage(Data.MESSAGE);
       updateOrderStatusPojo.setStatus(Data.STATUS_CONFIRMED);
       updateOrderStatusPojo.setTrackingNumber(Data.TRACKING_NUMBER);

       String path = Route.UPDATE_ORDER_STATUS + orderId + "/status";

        return RestResource.patchStatus(path, token, updateOrderStatusPojo);
    }

}
