package com.kbhit.orangebox.storage.integration;

import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class StoreItemIntegrationTest extends AbstractIntegrationTest {

    @Test
    public void canStoreItem() {
        given()
                .contentType("application/json").
                when()
                .get("/greet").
                then()
                .statusCode(200);
    }

}
