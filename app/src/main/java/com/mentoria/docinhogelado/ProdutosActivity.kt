package com.mentoria.docinhogelado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mentoria.docinhogelado.databinding.ActivityProdutosBinding
import com.mentoria.docinhogelado.model.Produto
import com.mentoria.docinhogelado.ui.ProdutoAdapter

class ProdutosActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityProdutosBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configuraRecyclerView()
    }

    private fun configuraRecyclerView() {
        val recyclerView = binding.recyclerView
        recyclerView.adapter = ProdutoAdapter(
            this, produtos = listOf(
                Produto(
                    nome = "Romeu e Julieta",
                    descricao = "Delicioso sorvete para refrescar",
                    valor = "R$ 8.99",
                    quantidade = 2
                ),
                Produto(
                    nome = "Sorvete de flocos",
                    descricao = "Delicioso sorvete para refrescar",
                    valor = "R$ 5.99",
                    quantidade = 1
                )
            )
        )
    }
}