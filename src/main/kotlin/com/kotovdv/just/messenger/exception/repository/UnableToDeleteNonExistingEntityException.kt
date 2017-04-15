package com.kotovdv.just.messenger.exception.repository

import com.kotovdv.just.messenger.exception.JustMessengerException

import java.io.Serializable

class UnableToDeleteNonExistingEntityException(id: Serializable, entityClass: Class<*>) : JustMessengerException(
        String.format("Unable to delete entity [%s] with id [%d] since it does not exist",
                entityClass.simpleName,
                id))

