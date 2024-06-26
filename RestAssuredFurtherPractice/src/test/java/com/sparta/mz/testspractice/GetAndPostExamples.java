package com.sparta.mz.testspractice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;


public class GetAndPostExamples {
    @Test
    public void testGet() {
        baseURI = "https://reqres.in/api/"; //users?page=2

        given()
                .get("/users?page=2")
                .then()
                .statusCode(200)
                .body("data[4].first_name", equalTo("George"))
                .body("data.first_name", hasItems("George", "Rachel"));
    }

    @Test
    public void testPost() {
        Map<String, Object> map = new HashMap();
//        map.put("name", "Raghav");
//        map.put("job", "Teacher");
        System.out.println(map);
        JSONObject request = new JSONObject();

        request.put("name", "Raghav");
        request.put("job", "Teacher");
        System.out.println(request.toJSONString());

        baseURI = "https://reqres.in/api/";
        given().
                header("Content-Type", "application/json").
                body(request.toJSONString())
                .when().
                post("/users").
                then().
                statusCode(201)
                .log().all();
    }
}
