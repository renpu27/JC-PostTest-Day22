package com.juaracoding.posttest22;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestMovieRating {

    String endpoint = "https://api.themoviedb.org/3/movie/631842/rating?api_key=d278c19a5f83728c2af4a001c0d199fc";

    @Test
    public void testRating(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("value", "8.5");
        System.out.println(requestBody.toJSONString());
        given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJkMjc4YzE5YTVmODM3MjhjMmFmNGEwMDFjMGQxOTlmYyIsInN1YiI6IjY0MDVmNTI4MzkyNzEyMDBlNTA3ZDg1MCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.ZnWVmaDIYyArFWD47SVQkmcy5QQD_lhY2tiqk0Un_qc")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(requestBody.toJSONString())
                .when()
                .post(endpoint).then()
                .statusCode(201)
//                .body("value",equalTo("8.5"))
                .log().all();
    }
}
