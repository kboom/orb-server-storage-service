package com.kbhit.orangebox.storage;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;

@Configuration
class PersistenceConfiguration {

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
    @Profile("postgres")
    public DataSource dataSource(
            @Value("${jdbc.driverClassName}") String driverClassName,
            @Value("${jdbc.url}") String url
    ) {
        DriverManagerDataSource bean = new DriverManagerDataSource();
        bean.setDriverClassName(driverClassName);
        bean.setUrl(url);
        return bean;
    }

    @Bean
    @Profile("H2")
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(H2).build();
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

}
