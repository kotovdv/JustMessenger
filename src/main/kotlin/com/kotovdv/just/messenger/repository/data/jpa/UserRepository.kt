package com.kotovdv.just.messenger.repository.data.jpa

import com.kotovdv.just.messenger.model.entity.User
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : BaseJpaRepository<User, Long>
