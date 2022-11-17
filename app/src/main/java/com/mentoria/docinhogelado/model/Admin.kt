package com.mentoria.docinhogelado.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Admin(
    @PrimaryKey
    var usuario: String,
    var senha: String
) : Parcelable