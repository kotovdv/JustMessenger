package com.kotovdv.just.messenger.repository

import com.github.springtestdbunit.annotation.DatabaseSetup
import com.github.springtestdbunit.annotation.ExpectedDatabase
import com.github.springtestdbunit.assertion.DatabaseAssertionMode.NON_STRICT
import com.kotovdv.just.messenger.model.entity.Chat
import com.kotovdv.just.messenger.repository.common.RepositoryTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Import

@Import(Chats::class)
class ChatTest : RepositoryTest() {

    @Autowired
    lateinit var chats: Chats

    @Test
    @ExpectedDatabase(value = "classpath:chats/add/after.xml", assertionMode = NON_STRICT)
    fun testChatAdd() {
        val chat = Chat(name = "MyChat")
        chats.addOrUpdate(chat)
    }

    @Test
    @DatabaseSetup(value = "classpath:chats/get/before.xml")
    fun testChatGet() {
        val chat = chats.get(1L) ?: throw AssertionError()

        assertThat(chat.name).isEqualTo("MyChat")
    }

    @Test
    @DatabaseSetup(value = "classpath:chats/user_list/before.xml")
    fun testUserList() {
        val chat = chats.get(1L) ?: throw AssertionError()

        assertThat(chat.users.size).isEqualTo(3)
    }
}
