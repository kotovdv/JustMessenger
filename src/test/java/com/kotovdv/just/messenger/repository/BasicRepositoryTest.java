package com.kotovdv.just.messenger.repository;

import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

/**
 * @author Dmitriy Kotov
 */
@DataJpaTest
@RunWith(SpringRunner.class)
@TestExecutionListeners(value = {
        DependencyInjectionTestExecutionListener.class,
        TransactionDbUnitTestExecutionListener.class})
public class BasicRepositoryTest {
}
