package com.kotovdv.just.messenger.exception

open class JustMessengerException : RuntimeException {

    constructor()

    constructor(message: String) : super(message)

    constructor(message: String, cause: Throwable) : super(message, cause)
}
