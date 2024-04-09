package com.sparta.mz.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class SinglePostCodeTests {

    private static Response response;

    @BeforeAll
    static void beforeAll() {
        response = RestAssured
                .given()
                .baseUri("https://api.postcodes.io")
                .basePath("/postcodes")
                .header("Accept", "text/json")
                .when()
                .log()
                .all()
                .get("/EC2Y5AS")
                .thenReturn();
    }

    @Test
    @DisplayName("Status code 200 returned")
    void testStatusCode200() {
        RestAssured
                .given()
                .baseUri("https://api.postcodes.io")
                .basePath("/postcodes")
                .header("Accept", "application/json")
                .when()
                .get("/EC2Y5AS")
                .then()
                .assertThat().statusCode(200);
    }

    @Test
    @DisplayName("Status code 200 returned")
    void testStatusCode200B() {
        MatcherAssert.assertThat(response.statusCode(), Matchers.is(200));
    }

    @Test
    @DisplayName("Test server name is cloudflare")
    void testServerNameIsCloud() {
        MatcherAssert.assertThat(response.header("Server"), Matchers.is("cloudflare"));
    }

    @Test
    @DisplayName("Correct postcode returned in response")
    void testCorrectPostcodeReturnedInResponse() {
        MatcherAssert.assertThat(
                response.jsonPath().getString("result.postcode"),
                Matchers.is("EC2Y 5AS"));
    }

    @Test
    @DisplayName("Check name of Primary Care Trust response is 'City and Hackney Teaching'")
    void checkPrimaryTrustResponseName() {
        MatcherAssert.assertThat(response.jsonPath().getString("result.primary_care_trust"), Matchers.is("City and Hackney Teaching"));
    }

    @Test
    @DisplayName("Check total number of codes returned is 14")
    void checkNumberOfCodesReturnedIs14() {
        System.out.println(response.jsonPath().getString("result"));
        Map<String, String> codesMap = response.jsonPath().getMap("result.codes");
        MatcherAssert.assertThat(codesMap.size(), Matchers.is(14));
    }
}