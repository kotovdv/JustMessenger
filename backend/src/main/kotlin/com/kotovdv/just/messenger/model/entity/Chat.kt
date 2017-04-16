package com.kotovdv.just.messenger.model.entity

import org.hibernate.annotations.BatchSize
import javax.persistence.*
import javax.persistence.FetchType.LAZY

@Entity
class Chat(@Id @GeneratedValue val id: Long? = null,
           @Column val name: String = "",
           @BatchSize(size = 50)
           @ManyToMany(fetch = LAZY, mappedBy = "chats")
           val users: List<User> = emptyList()) {

    override fun toString(): String {
        return "Chat(id=$id, name='$name')"
    }
}
