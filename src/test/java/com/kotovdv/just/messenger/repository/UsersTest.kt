package com.kotovdv.just.messenger.repository

import com.github.springtestdbunit.annotation.DatabaseSetup
import com.github.springtestdbunit.annotation.ExpectedDatabase
import com.github.springtestdbunit.assertion.DatabaseAssertionMode.NON_STRICT
import com.kotovdv.just.messenger.model.entity.User
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
    @Throws(Exception::class)
    fun testUserAdd() {
        val user = User(null, "John", "Doe", CREATION_DATE)
        users.addOrUpdate(user)
    }

    @Test
    @DatabaseSetup(value = "classpath:users/get/before.xml")
    fun testUserGet() {
        val user = users.get(1L) ?: throw AssertionError()

        assertThat(user.id).isEqualTo(1L)
        assertThat(user.firstName).isEqualTo("John")
        assertThat(user.lastName).isEqualTo("Doe")
        assertThat(user.creationDate).isEqualTo(CREATION_DATE)
    }

    @Test
    @DatabaseSetup("classpath:users/count/before.xml")
    fun testUserCount() {
        assertThat(users.size()).isEqualTo(3)
    }

    @Test
    @DatabaseSetup("classpath:users/remove_id/before.xml")
    @ExpectedDatabase(value = "classpath:users/remove_id/after.xml", assertionMode = NON_STRICT)
    @Throws(Exception::class)
    fun testRemoveByIdUser() {
        users.remove(1L)
        testEntityManager.flush()
    }

    @Test
    @DatabaseSetup("classpath:users/chat_list/before.xml")
    fun testChatList() {
        val user = users.get(1L) ?: throw AssertionError()

        assertThat(user.chats.size).isEqualTo(3)
    }
}
