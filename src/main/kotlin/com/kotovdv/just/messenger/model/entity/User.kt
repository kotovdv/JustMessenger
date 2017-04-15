package com.kotovdv.just.messenger.model.entity

import org.hibernate.annotations.BatchSize
import java.time.LocalDateTime
import java.time.LocalDateTime.MIN
import java.util.Collections.emptyList
import java.util.Collections.unmodifiableList
import javax.persistence.*
import javax.persistence.FetchType.LAZY

@Entity
data class User(@Id @GeneratedValue val id: Long? = null,
                @Column val firstName: String,
                @Column val lastName: String,
                @Column(name = "creation_dt") val creationDate: LocalDateTime,
                @ManyToMany(fetch = LAZY)
                @BatchSize(size = 50)
                @JoinTable(name = "user_chat",
                        joinColumns = arrayOf(JoinColumn(name = "USER_ID")),
                        inverseJoinColumns = arrayOf(JoinColumn(name = "CHAT_ID")))
                private val _chats: List<Chat> = emptyList()) {

    val chats: List<Chat>
        get() = unmodifiableList(_chats)

    constructor() : this(null, "", "", MIN, emptyList())

    override fun toString(): String {
        return "User(id=$id, firstName='$firstName', lastName='$lastName', creationDate=$creationDate)"
    }
}
