package com.kotovdv.just.messenger.repository

import com.kotovdv.just.messenger.model.entity.Message
import com.kotovdv.just.messenger.repository.common.AbstractRepository
import com.kotovdv.just.messenger.repository.data.jpa.MessageRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class Messages(@Autowired val repository: MessageRepository) : AbstractRepository<Message, Long>(repository, Message::class.java)