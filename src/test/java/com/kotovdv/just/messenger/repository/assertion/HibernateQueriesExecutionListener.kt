package com.kotovdv.just.messenger.repository.assertion

import org.assertj.core.api.Assertions.assertThat
import org.springframework.test.context.TestContext
import org.springframework.test.context.support.AbstractTestExecutionListener

class HibernateQueriesExecutionListener : AbstractTestExecutionListener() {

    override fun beforeTestMethod(testContext: TestContext?) {
        val testMethod = testContext!!.testMethod

        val expectedQueriesCount = testMethod.getAnnotation(ExpectedQueriesCount::class.java)
        if (expectedQueriesCount != null) {
            QueriesInspector.reset()
        }
    }

    override fun afterTestMethod(testContext: TestContext?) {
        val testMethod = testContext!!.testMethod

        val expectedQueriesCount = testMethod.getAnnotation(ExpectedQueriesCount::class.java)
        if (expectedQueriesCount != null) {
            val expected = expectedQueriesCount.count
            val actual = QueriesInspector.getCount() ?: 0

            assertThat(actual).describedAs("Expected and actual database queries count mismatch").isEqualTo(expected)
        }
    }
}