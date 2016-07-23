package com.kbhit.orangebox.storage

import static com.jayway.restassured.RestAssured.given


class StoreItemIntegrationTest extends AbstractIntegrationTest {

    def "Stores item"() {
        given:
        def request = given()
                .contentType("application/json")
        when:
        def response = request.when().get("/greet")

        then:
        response.then().statusCode(200);
    }

}
