package yoo.kotlinjooqpractice.domain

import org.jooq.DSLContext
import org.springframework.beans.factory.annotation.Autowired

class SelectService {

    @Autowired
    private val dsl: DSLContext? = null

    fun getAuthors() {
//        dsl?.selectFrom(author)
    }
}