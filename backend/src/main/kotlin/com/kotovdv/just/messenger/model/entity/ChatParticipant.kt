package com.kotovdv.just.messenger.model.entity

import javax.persistence.*


@Entity
@Table(name = "USER_CHAT")
class ChatParticipant(@Id @GeneratedValue var id: Long? = null,
                      @ManyToOne @JoinColumn(name = "CHAT_ID") val chat: Chat? = null,
                      @ManyToOne @JoinColumn(name = "USER_ID") val user: User? = null)