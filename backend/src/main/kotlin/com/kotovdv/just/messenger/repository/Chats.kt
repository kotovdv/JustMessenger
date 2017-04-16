package com.kotovdv.just.messenger.repository

import com.kotovdv.just.messenger.model.entity.Chat
import com.kotovdv.just.messenger.repository.common.AbstractRepository
import com.kotovdv.just.messenger.repository.data.jpa.ChatRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class Chats(@Autowired private val repository: ChatRepository) : AbstractRepository<Chat, Long>(repository, Chat::class.java)