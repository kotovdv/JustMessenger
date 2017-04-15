package com.kotovdv.just.messenger.repository.data.jpa

import com.kotovdv.just.messenger.model.entity.Chat
import org.springframework.stereotype.Repository

@Repository
interface ChatRepository : BaseJpaRepository<Chat, Long>
