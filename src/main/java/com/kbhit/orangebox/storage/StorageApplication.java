package com.kbhit.orangebox.storage;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.sql.DataSource;
import java.util.Properties;

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

    @Bean(name = "db.hibernateProperties")
    public Properties hibernateProperties(
            @Value("${hibernate.hbm2ddl.auto}") String hbm2dll,
            @Value("${hibernate.dialect}") String dialect) {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", hbm2dll);
        properties.setProperty("hibernate.dialect", dialect);
        return properties;
    }

    @Bean
    public DataSource dataSource(
            @Value("${jdbc.driverClassName}") String driverClassName,
            @Value("${jdbc.url}") String url,
            @Value("${jdbc.user}") String username,
            @Value("${jdbc.pass}") String password
    ) {
        DriverManagerDataSource bean = new DriverManagerDataSource();
        bean.setDriverClassName(driverClassName);
        bean.setUrl(url);
        bean.setUsername(username);
        bean.setPassword(password);
        return bean;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(
            @Qualifier("db.hibernateProperties") Properties hibernateProperties,
            DataSource dataSource) {
        LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setPackagesToScan("com.kbhit.orangebox.storage.domain.model");
        bean.setHibernateProperties(hibernateProperties);
        return bean;
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager bean = new HibernateTransactionManager();
        bean.setSessionFactory(sessionFactory);
        return bean;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor persistenceExceptionPostProcessor() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    public static void main(String[] args) {
        SpringApplication.run(StorageApplication.class, args);
    }

}
