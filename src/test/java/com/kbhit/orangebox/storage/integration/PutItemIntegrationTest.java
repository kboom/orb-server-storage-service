package com.kbhit.orangebox.storage.integration;

import com.jayway.restassured.RestAssured;
import com.kbhit.orangebox.storage.IntegrationTestContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.jayway.restassured.RestAssured.given;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = IntegrationTestContext.class)
@ActiveProfiles("dev")
@WebAppConfiguration
@IntegrationTest("server.port:0")   //
public class PutItemIntegrationTest {

    @Value("${local.server.port}")
    private int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
    }

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
