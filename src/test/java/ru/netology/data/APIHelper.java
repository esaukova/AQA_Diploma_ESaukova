package ru.netology.data;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import com.google.gson.Gson;

import static io.restassured.RestAssured.given;

public class APIHelper {
    private static final Gson gson = new Gson();

    private static RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("http://localhost")
            .setPort(9999)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    public static ValidatableResponse createPayment(String body, int statusCode) {
        return given()
                .spec(requestSpec)
                .body(body)
                .when()
                .post("/payment")
                .then()
                .statusCode(statusCode);
    }

    public static ValidatableResponse createCreditRequest(String body, int statusCode) {
        return given()
                .spec(requestSpec)
                .body(body)
                .when()
                .post("/api/v1/credit")
                .then()
                .statusCode(statusCode);
    }

}
