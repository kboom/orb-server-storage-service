package com.kbhit.orangebox.storage.integration;

import com.kbhit.orangebox.storage.StorageApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.jayway.restassured.RestAssured.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = StorageApplication.class)
@WebAppConfiguration
public class PutItemIntegrationTest {

    @Test
    public void canStoreItem() {
        given()
                .contentType("application/json").
        when()
                .get("/").
        then()
                .statusCode(200);
    }

}
