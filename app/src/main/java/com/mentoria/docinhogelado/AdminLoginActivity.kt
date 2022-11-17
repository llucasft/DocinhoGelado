package com.mentoria.docinhogelado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mentoria.docinhogelado.database.AppDataBase
import com.mentoria.docinhogelado.databinding.ActivityAdminLoginBinding

class AdminLoginActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityAdminLoginBinding.inflate(layoutInflater)
    }
    private val adminDao by lazy{
        AppDataBase.instancia(this).adminDao()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //Criar logica de cadastrar/autenticar admin
        val btnLogin = binding.botaoEntrar
        val btnCadastrar = binding.botaoCadastro
    }
}