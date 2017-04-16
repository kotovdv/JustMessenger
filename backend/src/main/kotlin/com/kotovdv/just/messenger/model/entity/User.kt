package com.kotovdv.just.messenger.model.entity

import org.hibernate.annotations.BatchSize
import java.time.LocalDateTime
import java.util.Collections.emptyList
import javax.persistence.*
import javax.persistence.FetchType.LAZY

@Entity
class User(@Id @GeneratedValue val id: Long? = null,
           @Column val firstName: String = "",
           @Column val lastName: String = "",
           @Column(name = "creation_dt") val creationDate: LocalDateTime = LocalDateTime.MIN,
           @ManyToMany(fetch = LAZY)
           @BatchSize(size = 50)
           @JoinTable(name = "user_chat",
                   joinColumns = arrayOf(JoinColumn(name = "USER_ID")),
                   inverseJoinColumns = arrayOf(JoinColumn(name = "CHAT_ID")))
           val chats: List<Chat> = emptyList()) {

    override fun toString(): String {
        return "User(id=$id, firstName='$firstName', lastName='$lastName', creationDate=$creationDate)"
    }
}
