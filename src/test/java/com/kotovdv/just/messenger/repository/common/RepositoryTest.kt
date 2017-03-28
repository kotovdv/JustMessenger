package com.kotovdv.just.messenger.repository.common

import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.context.annotation.Import
import org.springframework.test.context.TestExecutionListeners
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener

@DataJpaTest
@Import(TestDatabaseConfiguration::class)
@RunWith(SpringRunner::class)
@TestExecutionListeners(value = *arrayOf(DependencyInjectionTestExecutionListener::class, TransactionDbUnitTestExecutionListener::class))
abstract class RepositoryTest {

    @Autowired
    protected lateinit var testEntityManager: TestEntityManager

}
