package com.kotovdv.just.messenger.repository

import com.github.springtestdbunit.annotation.DatabaseSetup
import com.github.springtestdbunit.annotation.ExpectedDatabase
import com.github.springtestdbunit.assertion.DatabaseAssertionMode
import com.kotovdv.just.messenger.model.entity.ChatParticipant
import com.kotovdv.just.messenger.model.entity.Message
import com.kotovdv.just.messenger.repository.assertion.ExpectedQueriesCount
import com.kotovdv.just.messenger.repository.common.RepositoryTest
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Import
import java.time.LocalDateTime

@Import(Messages::class)
class MessagesTest : RepositoryTest() {

    private val CREATION_DATE = LocalDateTime.of(1970, 1, 1, 12, 0)

    @Autowired
    lateinit var messages: Messages

    @Test
    @DatabaseSetup(value = "classpath:messages/add/before.xml")
    @ExpectedDatabase(value = "classpath:chats/add/after.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
    @ExpectedQueriesCount(2)
    fun testMessageAdd() {
        val chatParticipant = testEntityManager.find(ChatParticipant::class.java, 1L)
        val message = Message(chatParticipant = chatParticipant,
                creationDt = CREATION_DATE,
                text = "Hello world!")

        messages.addOrUpdate(message)
    }
}