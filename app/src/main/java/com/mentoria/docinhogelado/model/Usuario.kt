package com.mentoria.docinhogelado.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Usuario(
    var login: String,
    var nome: String,
    var senha: String,
    @PrimaryKey
    var cpf: String,
    var telefone: String? = null,
    var endereco: String? = null,
    var bairro: String? = null,
    var cep: String? = null
) : Parcelable