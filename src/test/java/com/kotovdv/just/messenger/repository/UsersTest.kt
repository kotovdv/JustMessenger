package com.kotovdv.just.messenger.repository

import com.github.springtestdbunit.annotation.DatabaseSetup
import com.github.springtestdbunit.annotation.ExpectedDatabase
import com.github.springtestdbunit.assertion.DatabaseAssertionMode.NON_STRICT
import com.kotovdv.just.messenger.model.entity.User
import com.kotovdv.just.messenger.repository.assertion.ExpectedQueriesCount
import com.kotovdv.just.messenger.repository.common.RepositoryTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Import
import java.time.LocalDateTime.of

@Import(Users::class)
class UsersTest : RepositoryTest() {

    @Autowired
    lateinit var users: Users

    private val CREATION_DATE = of(1970, 1, 1, 12, 0)

    @Test
    @ExpectedDatabase(value = "classpath:users/add/after.xml", assertionMode = NON_STRICT)
    @ExpectedQueriesCount(1)
    fun testUserAdd() {
        val user = User(null, "John", "Doe", CREATION_DATE)
        users.addOrUpdate(user)
    }

    @Test
    @DatabaseSetup(value = "classpath:users/get/before.xml")
    @ExpectedQueriesCount(1)
    fun testUserGet() {
        val user = users.get(1L) ?: throw AssertionError()

        assertThat(user.id).isEqualTo(1L)
        assertThat(user.firstName).isEqualTo("John")
        assertThat(user.lastName).isEqualTo("Doe")
        assertThat(user.creationDate).isEqualTo(CREATION_DATE)
    }

    @Test
    @DatabaseSetup("classpath:users/size/before.xml")
    @ExpectedQueriesCount(1)
    fun testUserSize() {
        assertThat(users.size()).isEqualTo(3)
    }

    @Test
    @DatabaseSetup("classpath:users/remove/before.xml")
    @ExpectedDatabase(value = "classpath:users/remove/after.xml", assertionMode = NON_STRICT)
    @ExpectedQueriesCount(4)
    fun testUserRemove() {
        users.remove(1L)
        testEntityManager.flush()
    }

    @Test
    @DatabaseSetup("classpath:users/chat_list/before.xml")
    @ExpectedQueriesCount(2)
    fun testUserChatList() {
        val user = users.get(1L) ?: throw AssertionError()

        assertThat(user.chats.size).isEqualTo(3)
    }
}
