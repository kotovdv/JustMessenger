package com.kotovdv.just.messenger.repository;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.kotovdv.just.messenger.entity.User;
import com.kotovdv.just.messenger.repository.configuration.RepositoryTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static com.github.springtestdbunit.assertion.DatabaseAssertionMode.NON_STRICT;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Dmitriy Kotov
 */
public class UsersTest extends RepositoryTest {

    @Autowired
    private Users users;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    @ExpectedDatabase(value = "classpath:users/add/after.xml", assertionMode = NON_STRICT)
    public void testUserAdd() throws Exception {
        User user = new User("John", "Doe");
        users.save(user);
    }

    @Test
    @DatabaseSetup(value = "classpath:users/get/before.xml")
    public void testUserGet() {
        User user = users.findOne(1L);

        assertThat(user.getId()).isEqualTo(1L);
        assertThat(user.getFirstName()).isEqualTo("John");
        assertThat(user.getLastName()).isEqualTo("Doe");
    }

    @Test
    @DatabaseSetup("classpath:users/count/before.xml")
    public void testUserCount() {
        assertThat(users.count()).isEqualTo(3);
    }

    @Test
    @DatabaseSetup("classpath:users/remove_entity/before.xml")
    @ExpectedDatabase(value = "classpath:users/remove_entity/after.xml", assertionMode = NON_STRICT)
    public void testRemoveByEntityUser() throws Exception {
        User user = testEntityManager.find(User.class, 1L);

        users.delete(user);
        testEntityManager.flush();
    }

    @Test
    @DatabaseSetup("classpath:users/remove_id/before.xml")
    @ExpectedDatabase(value = "classpath:users/remove_id/after.xml", assertionMode = NON_STRICT)
    public void testRemoveByIdUser() throws Exception {
        users.delete(1L);
        testEntityManager.flush();
    }
}
