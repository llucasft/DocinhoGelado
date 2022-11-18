package com.mentoria.docinhogelado

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.mentoria.docinhogelado.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val botao = binding.botaoCadastro
        botao.setOnClickListener {
            val intent=Intent(this,CadastroUsuarioActivity::class.java)
            startActivity(intent)
        }
        val botaoLogin = binding.botaoEntrar
        botaoLogin.setOnClickListener {
            val intent = Intent(this,ProdutosActivity::class.java)
            startActivity(intent)
        }
    }
}