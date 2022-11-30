package com.mentoria.docinhogelado.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mentoria.docinhogelado.database.AppDataBase
import com.mentoria.docinhogelado.databinding.ActivityProdutosBinding
import com.mentoria.docinhogelado.model.Produto
import com.mentoria.docinhogelado.util.ProdutoClickListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProdutosActivity : AppCompatActivity(), ProdutoClickListener {
    private lateinit var binding: ActivityProdutosBinding
    private val adapter = ProdutoAdapter(context = this, this@ProdutosActivity)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProdutosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configuraRecyclerView()

        val fab = binding.fabAdicionarProduto
        val totalPedidoTv = binding.fabValorTotal
        val totalPedidoValor = adapter.valorTotalPedido
        totalPedidoTv.text = "Valor total do pedido R$$totalPedidoValor"

        fab.setOnClickListener {
            val intent = Intent(this, FormularioProdutoActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        val db = AppDataBase.instancia(this)
        val produtoDao = db.produtoDao()
        val scope = MainScope()
        scope.launch {
            val produtos = withContext(Dispatchers.IO) {
                produtoDao.buscaProdutos()
            }
            adapter.atualiza(produtos)
        }
    }

    private fun configuraRecyclerView() {
        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
    }

    override fun aumenta(produto: Produto, position: Int) {
        produto.quantidade += 1
        adapter.notifyItemChanged(position)
    }

    override fun diminui(produto: Produto, position: Int) {
        if (produto.quantidade > 0)
            produto.quantidade -= 1
        else
            Toast.makeText(
                this@ProdutosActivity,
                "Quantidade não pode ser menor que 0!",
                Toast.LENGTH_SHORT
            ).show()
        adapter.notifyItemChanged(position)
    }
}