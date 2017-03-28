package com.kotovdv.just.messenger.model.entity

import java.time.LocalDateTime
import java.time.LocalDateTime.MIN
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class User(@Id @GeneratedValue val id: Long? = null,
                @Column val firstName: String,
                @Column val lastName: String,
                @Column(name = "creation_dt") val creationDate: LocalDateTime) {
    constructor() : this(null, "", "", MIN)
}
