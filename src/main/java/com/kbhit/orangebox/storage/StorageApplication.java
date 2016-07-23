package com.kbhit.orangebox.storage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@SpringBootApplication
@EnableEurekaClient
@Configuration
@EnableSwagger2
@PropertySource({
        "properties/jdbc.properties",
        "properties/hibernate.properties",
        "properties/log4j.properties"
})
@Import(PersistenceConfiguration.class)
public class StorageApplication {

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

    public static void main(String[] args) {
        SpringApplication.run(StorageApplication.class, args);
    }

}
