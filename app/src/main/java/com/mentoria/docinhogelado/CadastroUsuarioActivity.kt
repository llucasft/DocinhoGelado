package com.mentoria.docinhogelado

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mentoria.docinhogelado.databinding.ActivityCadastroUsuarioBinding

class CadastroUsuarioActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityCadastroUsuarioBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val nomeCompleto = binding.nomeCompleto
        val espacoNomeCompleto = binding.espacoNomeCompleto
        val login = binding.login
        val espacoLogin = binding.espacoLogin
        val senha = binding.senha
        val espacoSenha = binding.espacoSenha
        val senhaConfirma = binding.senhaConfirma
        val espacoSenhaConfirma = binding.espacoSenhaConfirma
        val cpf = binding.cpf
        val espacoCpf = binding.espacoCpf
        val endereco = binding.endereco
        val espacoEndereco = binding.espacoEndereco
        val numeroEndereco = binding.numeroEndereco
        val espacoEnderecoNumero = binding.espacoEnderecoNumero
        val bairroEndereco = binding.bairroEndereco
        val espacoBairro = binding.espacoBairro
        val cepEndereco = binding.cepEndereco
        val espacoCepEndereco = binding.espacoCepEndereco

        // muda o título do nomeCompleto.text = "blablablabla"
        // isso acontece por causa do binding


    }
}