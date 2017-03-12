package com.kotovdv.just.messenger.repository.configuration;

import com.github.springtestdbunit.bean.DatabaseConfigBean;
import com.github.springtestdbunit.bean.DatabaseDataSourceConnectionFactoryBean;
import org.dbunit.ext.h2.H2DataTypeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * @author Dmitriy Kotov
 */
@TestConfiguration
public class TestDatabaseConfiguration {

    @Autowired
    private DataSource dataSource;

    @Bean
    public DatabaseDataSourceConnectionFactoryBean dbUnitDatabaseConnection() {
        DatabaseDataSourceConnectionFactoryBean dbConnection = new DatabaseDataSourceConnectionFactoryBean(dataSource);
        dbConnection.setDatabaseConfig(dbUnitDatabaseConfig());

        return dbConnection;
    }

    @Bean
    public DatabaseConfigBean dbUnitDatabaseConfig() {
        DatabaseConfigBean dbConfig = new DatabaseConfigBean();
        dbConfig.setDatatypeFactory(new H2DataTypeFactory());

        return dbConfig;
    }
}