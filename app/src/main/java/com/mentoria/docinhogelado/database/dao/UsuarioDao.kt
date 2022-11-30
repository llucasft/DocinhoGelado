package com.mentoria.docinhogelado.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mentoria.docinhogelado.model.Usuario
import kotlinx.coroutines.flow.Flow

@Dao
interface UsuarioDao {

    @Insert
    suspend fun salva(vararg usuario: Usuario)

    @Query("SELECT * FROM Usuario")
    fun buscaListaUsuario(): List<Usuario>

    @Query("SELECT * FROM Usuario WHERE login = :login AND senha = :senha")
    suspend fun autentica(login: String, senha: String): Usuario?

    @Query("SELECT * FROM Usuario WHERE login = :login")
    fun buscaPorLogin(login: String): Flow<Usuario>
}