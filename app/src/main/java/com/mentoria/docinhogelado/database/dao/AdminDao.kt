package com.mentoria.docinhogelado.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mentoria.docinhogelado.model.Admin

@Dao
interface AdminDao {

    @Insert
    fun salva(vararg admin: Admin)

    @Query("SELECT * FROM Admin")
    fun buscaListaAdmin(): List<Admin>
}