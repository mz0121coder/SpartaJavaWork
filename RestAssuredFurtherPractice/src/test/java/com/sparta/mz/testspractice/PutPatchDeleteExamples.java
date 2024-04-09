package com.sparta.mz.testspractice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PutPatchDeleteExamples {
    @Test
    public void testPut() {

        JSONObject request = new JSONObject();

        request.put("name", "Max");
        request.put("job", "Developer");
        System.out.println(request.toJSONString());

        baseURI = "https://reqres.in/api/";
        given().
                header("Content-Type", "application/json").
                body(request.toJSONString())
                .when()
                .put("/users/2")
                .then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    public void testPatch() {

        JSONObject request = new JSONObject();

        request.put("name", "Jessica");
        request.put("job", "SDET");
        System.out.println(request.toJSONString());

        baseURI = "https://reqres.in/api/";
        given().
                header("Content-Type", "application/json").
                body(request.toJSONString())
                .when()
                .patch("/api/users/2")
                .then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    public void testDelete() {
        baseURI = "https://reqres.in/api/";
        when()
                .delete("/api/users/2")
                .then()
                .statusCode(204)
                .log()
                .all();
    }
}
