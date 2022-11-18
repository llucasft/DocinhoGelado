package com.mentoria.docinhogelado.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Produto(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var nome: String,
    var descricao: String,
    var valor: String,
    var imagem: String? = null
) : Parcelable