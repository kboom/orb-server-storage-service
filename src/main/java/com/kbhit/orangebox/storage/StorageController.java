package com.kbhit.orangebox.storage;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class StorageController {

    @ApiOperation(value = "test", nickname = "testNickname")
    @RequestMapping(value = "/greet", consumes = "application/json")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
