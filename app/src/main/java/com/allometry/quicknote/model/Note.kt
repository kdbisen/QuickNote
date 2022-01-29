package com.allometry.quicknote.model

import java.time.LocalDateTime
import java.util.*

data class Note(

    val id: UUID = UUID.randomUUID(),
    val title: String,
    val description: String,
    val time: LocalDateTime = LocalDateTime.now()

)
