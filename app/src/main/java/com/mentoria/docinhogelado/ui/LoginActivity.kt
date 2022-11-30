package com.mentoria.docinhogelado.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.lifecycleScope
import com.mentoria.docinhogelado.database.AppDataBase
import com.mentoria.docinhogelado.databinding.ActivityLoginBinding
import com.mentoria.docinhogelado.preferences.dataStore
import com.mentoria.docinhogelado.preferences.usuarioLogadoPreferences
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    private val usuarioDao by lazy {
        AppDataBase.instancia(this).usuarioDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val botao = binding.botaoCadastro
        supportActionBar?.hide()
        botao.setOnClickListener {
            val intent = Intent(this@LoginActivity, CadastroUsuarioActivity::class.java)
            startActivity(intent)
        }
        val botaoLogin = binding.botaoEntrar
        botaoLogin.setOnClickListener {
            val usuarioLogin = binding.etLogin.text.toString()
            val usuarioSenha = binding.etSenha.text.toString()
            verificaDados(usuarioLogin, usuarioSenha)
        }
    }

    private fun verificaDados(usuarioLogin: String, usuarioSenha: String) {
        lifecycleScope.launch {
            usuarioDao.autentica(usuarioLogin, usuarioSenha)?.let { usuario ->
                dataStore.edit { preferences ->
                    preferences[usuarioLogadoPreferences] = usuario.login
                }
                val intent = Intent(this@LoginActivity, ProdutosActivity::class.java)
                startActivity(intent)
                finish()
            } ?: Toast.makeText(
                this@LoginActivity,
                "Falha no login, verifique seus dados",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
