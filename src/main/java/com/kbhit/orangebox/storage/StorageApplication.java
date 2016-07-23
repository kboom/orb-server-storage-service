package com.kbhit.orangebox.storage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@Configuration
@EnableSwagger2
@PropertySource({
        "classpath:properties/jdbc.properties",
        "classpath:properties/hibernate.properties",
        "classpath:properties/log4j.properties"
})
@Import({PersistenceConfiguration.class, SwaggerConfiguration.class})
public class StorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(StorageApplication.class, args);
    }

}
