package com.mentoria.docinhogelado.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.mentoria.docinhogelado.R
import com.mentoria.docinhogelado.database.AppDataBase
import com.mentoria.docinhogelado.databinding.ActivityFormularioProdutoBinding
import com.mentoria.docinhogelado.model.Produto
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FormularioProdutoActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFormularioProdutoBinding.inflate(layoutInflater)
    }
    private val produtoDao by lazy {
        AppDataBase.instancia(this).produtoDao()
    }
    private val scope = CoroutineScope(Dispatchers.IO)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        title = "Cadastrar novo produto"
        val btnSalvar = binding.button

        btnSalvar.setOnClickListener {
            val novoProduto = criarNovoProduto()
            scope.launch {
                produtoDao.salva(novoProduto)
                finish()
            }
        }

        binding.imagemFormulario.setOnClickListener {
            AlertDialog.Builder(this)
                .setView(R.layout.dialog_imagem_layout)
                .setPositiveButton("Confirmar"){_, _ ->

                }
                .setNegativeButton("Cancelar"){_, _ ->

                }
                .show()
        }
    }

    private fun criarNovoProduto(): Produto {
        val produtoNome = binding.etNome
        val nome = produtoNome.text.toString()
        val produtoDescricao = binding.etDescricao
        val descricao = produtoDescricao.text.toString()
        val produtoValor = binding.etValor
        val valor = produtoValor.text.toString()

        return Produto(
            nome = nome,
            descricao = descricao,
            valor = valor
        )
    }
}