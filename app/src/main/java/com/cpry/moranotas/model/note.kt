package com.cpry.moranotas.model

import java.util.*

data class note (
    val id: Int,
    val creationDate: Date,
    var title: String,
    var body: String,
    var lastModificationDate: Date,
    var category: String
)