package com.kotovdv.just.messenger.model.entity

import org.hibernate.annotations.BatchSize
import java.util.Collections.emptyList
import java.util.Collections.unmodifiableList
import javax.persistence.*
import javax.persistence.FetchType.LAZY

@Entity
data class Chat(@Id @GeneratedValue val id: Long? = null,
                @Column val name: String,
                @BatchSize(size = 50)
                @ManyToMany(fetch = LAZY, mappedBy = "_chats")
                private val _users: List<User> = emptyList()) {

    val users: List<User>
        get() = unmodifiableList(_users)

    constructor() : this(name = "")

    override fun toString(): String {
        return "Chat(id=$id, name='$name')"
    }
}
