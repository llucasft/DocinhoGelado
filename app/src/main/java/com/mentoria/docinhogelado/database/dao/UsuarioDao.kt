package com.mentoria.docinhogelado.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mentoria.docinhogelado.model.Usuario

@Dao
interface UsuarioDao {

    @Insert
    fun salva(vararg usuario: Usuario)

    @Query("SELECT * FROM Usuario")
    fun buscaListaUsuario(): List<Usuario>
}