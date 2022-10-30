package yoo.kotlinjooqpractice.config

import org.jooq.ExecuteContext
import org.jooq.SQLDialect
import org.jooq.impl.DefaultExecuteListener
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator

class ExceptionTranslator : DefaultExecuteListener() {

    override fun exception(context: ExecuteContext?) {
        val dialect: SQLDialect? = context?.configuration()?.dialect()
        val translator: SQLErrorCodeSQLExceptionTranslator? = dialect?.thirdParty()?.springDbName()?.let { SQLErrorCodeSQLExceptionTranslator(it) }

        context?.exception(
            context.sqlException()?.let { translator?.translate("Access database using jOOQ", context.sql(), it) })
    }
}