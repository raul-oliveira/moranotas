package com.cpry.moranotas.model

import java.util.*

data class Note (
    val id: Int,
    val creationDate: Date,
    var title: String,
    var body: String,
    var lastModificationDate: Date,
    var category: String
)