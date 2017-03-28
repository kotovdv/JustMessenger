package com.kotovdv.just.messenger.repository

import com.kotovdv.just.messenger.model.entity.User
import com.kotovdv.just.messenger.repository.common.AbstractRepository
import com.kotovdv.just.messenger.repository.data.jpa.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class Users(@Autowired val repository: UserRepository) : AbstractRepository<User, Long>(repository, User::class.java)