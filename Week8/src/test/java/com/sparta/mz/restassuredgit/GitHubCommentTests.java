package com.sparta.mz.restassuredgit;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GitHubCommentTests {

    public static final String BASE_URI = "https://api.github.com";
    public static final String BASE_PATH = "/repos/{owner}/{repo}";

    private Integer commentId;

    @BeforeEach
    void setUp() {
        this.commentId =
                given(getRequestSpecification()
                        .setBasePath(BASE_PATH + "/commits/{commit_sha}/comments")
                        .addPathParam("commit_sha", "9bc4604")
                        .setBody("""
                                    {
                                        "body": "Commit comment test"
                                    }
                                """)
                        .build())
                        .when()
                        .post()
                        .then()
                        .assertThat().statusCode(201)
                        .extract().jsonPath().get("id");
    }

    @AfterEach
    void tearDown() {
        List<Integer> commentIds =
                given(getRequestSpecification()
                        .setBasePath(BASE_PATH)
                        .build())
                        .when()
                        .get("/comments")
                        .then()
                        .spec(getJsonResponseWithStatus(200))
                        .extract().jsonPath().getList("id");

        for (Integer commentId : commentIds) {
            given(getRequestSpecification()
                    .setBasePath(BASE_PATH + "/comments/{comment_id}")
                    .addPathParam("comment_id", commentId)
                    .build())
                    .when()
                    .delete()
                    .then()
                    .spec(getReponseStatus(204));
        }
    }


    @Test
    @DisplayName("Get all repository comments returns 1 comment")
    void getAllRepositoryComments_Returns1Comment() {
        Integer numberOfComments =
                given(getRequestSpecification().build())
                        .when()
                        .get("/comments")
                        .then()
                        .spec(getJsonResponseWithStatus(200))
                        .log().all()
                        .extract()
                        .jsonPath()
                        .getList("$")
                        .size();
        MatcherAssert.assertThat(numberOfComments, Matchers.is(1));
    }


    @Test
    @DisplayName("Get comment with a specific Id returns a comment with that Id")
    void getCommentWithId_ReturnsThatComment() {
        Integer NewId =
                given(getRequestSpecification()
                        .setBasePath(BASE_PATH + "/comments/{comment_id}")
                        .addPathParam("comment_id", commentId)
                        .build())
                        .when()
                        .get()
                        .then()
                        .log().all()
                        .spec(getJsonResponseWithStatus(200))
                        .extract()
                        .jsonPath().get("id");
        MatcherAssert.assertThat(NewId, Matchers.is(commentId));
    }

    @Test
    @DisplayName("Patch a comment with new content returns that content")
    void patchCommentWithNewContent_ReturnsNewContentInResponseBody() {

        String patchedBodyContent =
                given(getRequestSpecification()
                        .setBasePath(BASE_PATH + "/comments/{comment_id}")
                        .addPathParam("comment_id", commentId)
                        .build())
                        .when()
                        .body("""
                                {
                                  "body": "New Content"
                                }
                                  """)
                        .patch()
                        .then()
                        .spec(getJsonResponseWithStatus(200))
                        .extract()
                        .jsonPath()
                        .get("body");
        MatcherAssert.assertThat(patchedBodyContent, Matchers.is("New Content"));

    }

    private ResponseSpecification getJsonResponseWithStatus(Integer status) {
        return new ResponseSpecBuilder()
                .expectStatusCode(status)
                .expectContentType(ContentType.JSON)
                .build();
    }

    private ResponseSpecification getReponseStatus(Integer status) {
        return new ResponseSpecBuilder()
                .expectStatusCode(status)
                .build();
    }

    private RequestSpecBuilder getRequestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(BASE_PATH)
                .addHeaders(Map.of(
                        "Accept", "application/vnd.github+json",
                        "Authorization", "Bearer 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",
                        "X-GitHub-Api-Version", "2022-11-28"
                ))
                .addPathParams(Map.of(
                        "owner", "mz0121coder",
                        "repo", "testing"
                ));
    }
}