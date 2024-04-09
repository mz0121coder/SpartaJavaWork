package com.sparta.mz.testspractice;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class TestsExamples {
    @Test
    public void test_1() {
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void test_2() {
        String baseURI = "https://reqres.in/api/users?page=2";
        given()
                .get(baseURI)
                .then()
                .statusCode(200)
                .body("data.id[1]", equalTo(8))
                .log().all();
    }
}
