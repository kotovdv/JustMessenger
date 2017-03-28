package com.kotovdv.just.messenger.repository.common

import com.kotovdv.just.messenger.exception.repository.UnableToDeleteNonExistingEntityException
import org.springframework.data.jpa.repository.JpaRepository
import java.io.Serializable

abstract class AbstractRepository<T, in ID : Serializable>(
        private val repository: JpaRepository<T, ID>,
        private val classType: Class<T>) {

    fun addOrUpdate(entity: T): T {
        return repository.save(entity)
    }

    fun get(id: ID): T? {
        return repository.findOne(id)
    }

    fun remove(id: ID) {
        if (!repository.exists(id)) {
            throw UnableToDeleteNonExistingEntityException(id, classType)
        }

        repository.delete(id)
    }

    fun size(): Long {
        return repository.count()
    }
}
