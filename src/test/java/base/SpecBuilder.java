package base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utils.ConfigLoader;

public class SpecBuilder {

        public static RequestSpecification getRequestSpec() {
            return new RequestSpecBuilder()
                    .setBaseUri(ConfigLoader.getBaseUrl())
                    .setContentType("application/json")
                    .build();
        }

        public static ResponseSpecification getResponseSpec() {
            return new ResponseSpecBuilder()
                    .build();
        }
    }

