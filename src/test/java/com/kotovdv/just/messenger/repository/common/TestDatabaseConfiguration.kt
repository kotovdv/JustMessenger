package com.kotovdv.just.messenger.repository.common

import com.github.springtestdbunit.bean.DatabaseConfigBean
import com.github.springtestdbunit.bean.DatabaseDataSourceConnectionFactoryBean
import org.dbunit.ext.h2.H2DataTypeFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean

import javax.sql.DataSource

/**
 * @author Dmitriy Kotov
 */
@TestConfiguration
open class TestDatabaseConfiguration {

    @Qualifier("dataSource") @Autowired
    lateinit var dataSource: DataSource

    @Bean
    fun dbUnitDatabaseConnection(): DatabaseDataSourceConnectionFactoryBean {
        val dbConnection = DatabaseDataSourceConnectionFactoryBean(dataSource)
        dbConnection.setDatabaseConfig(dbUnitDatabaseConfig())

        return dbConnection
    }

    @Bean
    fun dbUnitDatabaseConfig(): DatabaseConfigBean {
        val dbConfig = DatabaseConfigBean()
        dbConfig.datatypeFactory = H2DataTypeFactory()

        return dbConfig
    }
}