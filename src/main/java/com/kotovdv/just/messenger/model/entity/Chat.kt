package com.kotovdv.just.messenger.model.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Chat(@Id @GeneratedValue val id: Long? = null,
                @Column val name: String) {
    constructor() : this(null, "")
}
