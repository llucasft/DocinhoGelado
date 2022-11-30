package com.mentoria.docinhogelado.model

import androidx.room.PrimaryKey

data class Pedido(
    @PrimaryKey
    val id: Long = 0L,
    val produtoId: String,
    val usuarioId: String,
    var valor: Double = 0.0
)