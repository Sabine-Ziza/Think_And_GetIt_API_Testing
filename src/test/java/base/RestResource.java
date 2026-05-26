
package base;

import io.restassured.response.Response;

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

    public static Response get(String path) {
        return given()
                .spec(SpecBuilder.getRequestSpec())
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


}