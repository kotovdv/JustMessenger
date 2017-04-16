package com.kotovdv.just.messenger.model.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Message(@Id @GeneratedValue val id: Long? = null,
              @ManyToOne @JoinColumn(name = "USER_CHAT_ID") val chatParticipant: ChatParticipant,
              @Column(name = "CREATION_DT") val creationDt: LocalDateTime = LocalDateTime.MIN,
              @Column val text: String = "") {


    override fun toString(): String {
        return "Message(creationDt=$creationDt, text='$text')"
    }
}