package yoo.kotlinjooqpractice.config

import org.h2.jdbcx.JdbcDataSource
import org.jooq.SQLDialect
import org.jooq.impl.DataSourceConnectionProvider
import org.jooq.impl.DefaultConfiguration
import org.jooq.impl.DefaultDSLContext
import org.jooq.impl.DefaultExecuteListenerProvider
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.jooq.JooqExceptionTranslator
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy
import javax.sql.DataSource


@Configuration
@ComponentScan(basePackages = arrayOf("yoo.kotlinjooqpractice.domain"))
class PersistenceContext {

    @Value("\${spring.datasource.url}")
    private val url: String = ""

    @Value("\${spring.datasource.username}")
    private val username: String = ""

    @Value("\${spring.datasource.password}")
    private val password: String = ""

    @Bean
    fun dataSource(): DataSource {
        val dataSource = JdbcDataSource()
        dataSource.setUrl(url)
        dataSource.setUser(username)
        dataSource.setPassword(password)
        return dataSource
    }

    @Bean
    fun transactionAwareDataSource(): TransactionAwareDataSourceProxy? {
        return TransactionAwareDataSourceProxy(dataSource())
    }

    @Bean
    fun transactionManager(): DataSourceTransactionManager? {
        return DataSourceTransactionManager(dataSource())
    }

    @Bean
    fun connectionProvider(): DataSourceConnectionProvider? {
        return DataSourceConnectionProvider(transactionAwareDataSource())
    }

    @Bean
    fun exceptionTransformer(): JooqExceptionTranslator {
        return JooqExceptionTranslator()
    }

    @Bean
    fun dsl(): DefaultDSLContext? {
        return DefaultDSLContext(configuration())
    }

    @Bean
    fun configuration(): DefaultConfiguration? {
        val jooqConfiguration = DefaultConfiguration()
        jooqConfiguration.set(connectionProvider())
        jooqConfiguration.set(DefaultExecuteListenerProvider(exceptionTransformer()))
        val dialect = SQLDialect.valueOf("H2")
        jooqConfiguration.set(dialect)
        return jooqConfiguration
    }
}