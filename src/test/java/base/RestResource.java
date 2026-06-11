
package base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.ProductPojo;

import java.io.File;

import static base.SpecBuilder.getRequestSpec;
import static base.SpecBuilder.getResponseSpec;
import static io.restassured.RestAssured.given;


public class RestResource {

    public static Response post(String path, Object payload) {
        return given()
                .spec(SpecBuilder.getRequestSpec())
                .body(payload)
                .when()
                .post(path)
                .then().log().all()
                .spec(getResponseSpec())
                .extract()
                .response();
    }

    public static Response addAddress(String endpoint, String token, Object payload) {
        return given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .spec(SpecBuilder.getRequestSpec())
                .body(payload)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }

    public static Response updateProfile(String endpoint, String token, Object payload) {
        return given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .spec(SpecBuilder.getRequestSpec())
                .body(payload)
                .when()
                .put(endpoint)
                .then()
                .extract()
                .response();
    }

    public static Response changePasswords(String endpoint,
                                           String token,
                                           Object payload) {

        Response response = given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .spec(SpecBuilder.getRequestSpec())
                .body(payload)
                .log().all()
                .when()
                .put(endpoint)
                .then()
                .log().all()
                .extract()
                .response();


        return response;


    }

    public static Response postAvatar(String endpoint,
                               String token,
                               File file) {
        System.out.println("Base URI = " + RestAssured.baseURI);
        System.out.println("Endpoint = " + endpoint);

        return given()
                .header("Authorization", "Bearer " + token)
                .multiPart("avatar", file, "image/png")
                .when()
                .post(endpoint)
                .then()
                .log().all()
                .extract()
                .response();

    }
    public static Response postProduct(String endpoint,
                                       String token,
                                       Object payload) {

        return given()
                .spec(SpecBuilder.getRequestSpec())
                .header("Authorization", "Bearer " + token)
                .body(payload)
                .when()
                .post(endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public static Response get(String path) {
        return given()
                .spec(SpecBuilder.getRequestSpec())
                .log().all()
                .when()
                .get(path)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }

    public static Response getCurrentUser(String path, String token) {
        return given()
                .spec(SpecBuilder.getRequestSpec())
                .header("Authorization", "Bearer " + token)
                .when()
                .get(path)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }

    public static Response delete(String endpoint, String token) {
        return given()
                .spec(SpecBuilder.getRequestSpec())
                .header("Authorization", "Bearer " + token)
                .when()
                .delete(endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }
    public static Response patch(String endpoint, String token) {
        return given()
                .spec(SpecBuilder.getRequestSpec())
                .header("Authorization", "Bearer " + token)
                .when()
                .patch(endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }

}