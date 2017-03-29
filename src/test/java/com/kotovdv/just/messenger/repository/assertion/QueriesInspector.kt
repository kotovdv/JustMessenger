package com.kotovdv.just.messenger.repository.assertion

import org.hibernate.resource.jdbc.spi.StatementInspector

class QueriesInspector : StatementInspector {

    override fun inspect(sql: String?): String? {
        val currentCount = queryCount.get() ?: 0
        queryCount.set(currentCount + 1)

        return sql
    }

    companion object Accessor {
        private val queryCount = ThreadLocal<Int>()
        fun reset() {
            queryCount.set(0)
        }

        fun getCount(): Int? {
            return queryCount.get()
        }
    }
}