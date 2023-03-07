package com.juaracoding.posttest22;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestMoviePopular {
    String endpoint = "https://api.themoviedb.org/3/movie/popular?api_key=d278c19a5f83728c2af4a001c0d199fc&language=en-US&page=2";

    @Test
    public void testPopular(){
        Response response = RestAssured.get(endpoint);

        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println(response.header("content-type"));
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test
    public void testIdOne() {
        given()
                .get(endpoint)
                .then()
                .statusCode(200)
                .body("results.id[0]", equalTo(843794));
    }

    @Test
    public void testIdTwo() {
        given()
                .get(endpoint)
                .then()
                .statusCode(200)
                .body("results.id[1]", equalTo(785084));
    }
}
