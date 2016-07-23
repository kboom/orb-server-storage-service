package com.kbhit.orangebox.storage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket storageApplicationAPI() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("storage")
                .apiInfo(new ApiInfoBuilder()
                        .title("Orangebox Storage Service")
                        .description("Service responsible for storing items")
                        .build())
                .select()
                .paths(regex("(/.*)"))
                .build();
    }

}
