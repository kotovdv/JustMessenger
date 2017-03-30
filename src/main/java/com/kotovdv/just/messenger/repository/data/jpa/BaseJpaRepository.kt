package com.kotovdv.just.messenger.repository.data.jpa

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean
import java.io.Serializable

@NoRepositoryBean
interface BaseJpaRepository<T, ID : Serializable> : JpaRepository<T, ID> {

    fun deleteById(id: ID): Long
}