package base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utils.ConfigLoader;

public class SpecBuilder {

        public static RequestSpecification getRequestSpec() {
            return new RequestSpecBuilder()
                    .setBaseUri(ConfigLoader.getBaseUrl())
                    .setContentType(ContentType.JSON)
                    .build();
        }

        public static ResponseSpecification getResponseSpec() {
            return new ResponseSpecBuilder()
                    .build();
        }
    }

