package com.kotovdv.just.messenger.repository.common

import com.kotovdv.just.messenger.exception.repository.UnableToDeleteNonExistingEntityException
import com.kotovdv.just.messenger.repository.data.jpa.BaseJpaRepository
import java.io.Serializable

abstract class AbstractRepository<T, in ID : Serializable>(
        private val repository: BaseJpaRepository<T, ID>,
        private val entityClass: Class<T>) {

    fun addOrUpdate(entity: T): T {
        return repository.save(entity)
    }

    fun get(id: ID): T? {
        return repository.findOne(id)
    }

    fun remove(id: ID) {
        val deletedCount = repository.deleteById(id)
        if (deletedCount != 1L) {
            throw UnableToDeleteNonExistingEntityException(id, entityClass)
        }
    }

    fun size(): Long {
        return repository.count()
    }
}
