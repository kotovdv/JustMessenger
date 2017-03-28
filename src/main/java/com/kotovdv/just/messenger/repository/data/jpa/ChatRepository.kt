package com.kotovdv.just.messenger.repository.data.jpa

import com.kotovdv.just.messenger.model.entity.Chat
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ChatRepository : JpaRepository<Chat, Long>
