package com.mentoria.docinhogelado

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var botao= findViewById<Button>(R.id.botaoCadastro)
        botao.setOnClickListener {
            val intent=Intent(this,CadastroUsuarioActivity::class.java)
            startActivity(intent)
        }
    }
}