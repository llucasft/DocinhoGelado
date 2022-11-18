package com.mentoria.docinhogelado.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.mentoria.docinhogelado.model.Produto

@Dao
interface ProdutoDao {

    @Insert(onConflict = REPLACE)
    fun salva(vararg produto: Produto)

    @Query("SELECT * FROM Produto")
    fun buscaProdutos(): List<Produto>
}