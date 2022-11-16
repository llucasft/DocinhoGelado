package com.mentoria.docinhogelado.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mentoria.docinhogelado.database.dao.AdminDao
import com.mentoria.docinhogelado.database.dao.ProdutoDao
import com.mentoria.docinhogelado.database.dao.UsuarioDao
import com.mentoria.docinhogelado.model.Admin
import com.mentoria.docinhogelado.model.Produto
import com.mentoria.docinhogelado.model.Usuario

@Database(
    entities = [
        Admin::class,
        Produto::class,
        Usuario::class
    ],
    version = 1
)
abstract class AppDataBase : RoomDatabase() {

    abstract fun adminDao(): AdminDao
    abstract fun produtoDao(): ProdutoDao
    abstract fun usuarioDao(): UsuarioDao

    companion object {
        @Volatile
        private var db: AppDataBase? = null
        fun instancia(context: Context): AppDataBase {
            return db ?: Room.databaseBuilder(
                context,
                AppDataBase::class.java,
                "orgs.db"
            ).build().also {
                db = it
            }
        }
    }
}