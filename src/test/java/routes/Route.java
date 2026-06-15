package routes;


import org.apache.http.impl.cookie.PublicSuffixDomainFilter;
import org.testng.ITestMethodFinder;
import payload.ProductPojo;

import javax.management.modelmbean.ModelMBeanNotificationBroadcaster;

public class Route {
    public static final String LOGIN = "/auth/login";
    public static final String CURRENT_USER = "/auth/me";
    public static final String VERIFY_EMAIL = "/auth/verify-email/";
    public static final String CREATE_USER = "/auth/register";
    public static final String FORGOT_EMAIL = "/auth/forgot-password";
    public static final String REFRESH_TOKEN = "/auth/refresh";
    public static final String USER_ADDRESS = "/users/addresses";
    public static final String NEW_ADDRESS = "/users/addresses";
    public static final String CHANGE_PASSWORD = "/users/change-password";
    public static final String AVATAR_LINK = "/users/avatar";
    public static final String UPDATE_PROFILE = "/users/profile";
    public static final String CATEGORIES = "/categories";
    public static final String SINGLE_CATEGORIES = "/categories/";
    public static final String PRODUCT = "/products";
    public static final String SINGLE_PRODUCT = "/products/";
    public static final String TRANDING_PRODUCT = "/products/trending";
    public static final String FLASH_SALES = "/products/flash-sales";
    public static final String RELATED_PRODUCT = "/products/";
    public static final String RELATED_PRODUCT_SUFFIX = "/related";
    public static final String CART = "/cart";
    public static final String ADD_CART = "/cart/items/";
    public static final String UPDATE_CART = "/cart/items/";
    public static final String ORDERS = "/orders";
    public static final String SINGLE_ORDER ="/orders/";
    public static final String DELETE_SINGLE_ITEM ="/cart/items/";
    public static final String SAVE_ITEM="/cart/items/";
    public static final String COUPON ="/cart/coupon";
    public static final String CANCEL_ORDER ="/orders/";
    public static  String RETURN_ORDERS="/orders/";
    public static String PAYMENT="/orders/";
    public static String ALL_ORDERS ="/orders/admin/all";
    public static String UPDATE_ORDER_STATUS ="/orders/admin/";
    public static String REVIEWS ="/reviews/";
    public static String SUBMIT_REVIEWS ="/reviews/";
    public static String WISHLIST ="/wishlist";
    public static String WISHLIST_ADD_PRODUCT ="/wishlist/";

}