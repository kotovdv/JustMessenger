package com.kotovdv.just.messenger.repository;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.kotovdv.just.messenger.entity.User;
import com.kotovdv.just.messenger.repository.configuration.RepositoryTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;

import static com.github.springtestdbunit.assertion.DatabaseAssertionMode.NON_STRICT;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Dmitriy Kotov
 */
@Import(Users.class)
public class UsersTest extends RepositoryTest {

    @Autowired
    private Users users;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    @ExpectedDatabase(value = "classpath:users/user.adding.xml", assertionMode = NON_STRICT)
    public void testUserAdding() throws Exception {
        User user = new User("John", "Doe");
        users.add(user);
    }

    @Test
    @DatabaseSetup(value = "classpath:users/user.getting.xml")
    public void testUserGet() {
        User user = users.get(1L);

        assertThat(user.getId()).isEqualTo(1L);
        assertThat(user.getFirstName()).isEqualTo("John");
        assertThat(user.getLastName()).isEqualTo("Doe");
    }

    @Test
    @DatabaseSetup("classpath:users/user.count.xml")
    public void testUserCount() {
        assertThat(users.size()).isEqualTo(3);
    }

    @Test
    @DatabaseSetup("classpath:users/user.remove.before.xml")
    @ExpectedDatabase(value = "classpath:users/user.remove.after.xml", assertionMode = NON_STRICT)
    public void testRemoveUser() throws Exception {
        User user = testEntityManager.find(User.class, 1L);

        users.remove(user);
    }
}
