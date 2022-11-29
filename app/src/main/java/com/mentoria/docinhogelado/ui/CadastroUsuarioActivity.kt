package com.mentoria.docinhogelado.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.mentoria.docinhogelado.database.AppDataBase
import com.mentoria.docinhogelado.databinding.ActivityCadastroUsuarioBinding
import com.mentoria.docinhogelado.model.Usuario
import kotlinx.coroutines.launch

class CadastroUsuarioActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityCadastroUsuarioBinding.inflate(layoutInflater)
    }
    private val usuarioDao by lazy {
        AppDataBase.instancia(this).usuarioDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        var confirmacaoSenha = ""

        val btnCadastrar = binding.botaoConfirmar
        btnCadastrar.setOnClickListener {
            val novoUsuario = criaUsuario()
            val verificaLogin = verificaLoginExiste(novoUsuario.login)
            confirmacaoSenha = binding.espacoSenhaConfirma.text.toString()
            if (confirmacaoSenha == novoUsuario.senha){
                if (verificaLogin) {
                    Toast.makeText(
                        this@CadastroUsuarioActivity,
                        "Usuário já cadastrado!",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    cadastra(novoUsuario)
                }
            } else {
                binding.espacoSenha.error = "As senhas precisam ser idênticas. "
                binding.espacoSenhaConfirma.error = "As senhas precisam ser idênticas. "
            }
        }
    }

    private fun cadastra(usuario: Usuario) {
        lifecycleScope.launch {
            try {
                usuarioDao.salva(usuario)
                finish()
            } catch (e: Exception) {
                Log.e("CadastroUsuario", "configuraBotaoCadastrar: ", e)
                Toast.makeText(
                    this@CadastroUsuarioActivity,
                    "Falha ao cadastrar usuário!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun verificaLoginExiste(login: String): Boolean {
        var verificacao = false
        lifecycleScope.launch {
            if (usuarioDao.buscaPorLogin(login) != null) {
                verificacao = true
            }
        }
        return verificacao
    }

    private fun criaUsuario(): Usuario {

        val nomeCompleto = binding.espacoNomeCompleto.text.toString()
        val login = binding.espacoLogin.text.toString()
        val senha = binding.espacoSenha.text.toString()
        val cpf = binding.espacoCpf.text.toString()
        val endereco = binding.espacoEndereco.text.toString()
        val cep = binding.espacoCepEndereco.text.toString()
        val bairro = binding.espacoBairro.text.toString()
        return Usuario(
            nome = nomeCompleto,
            login = login,
            senha = senha,
            cpf = cpf,
            endereco = endereco,
            cep = cep,
            bairro = bairro
        )
    }
}