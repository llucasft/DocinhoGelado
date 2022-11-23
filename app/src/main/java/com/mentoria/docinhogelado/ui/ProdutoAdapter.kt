package com.mentoria.docinhogelado.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.mentoria.docinhogelado.R
import com.mentoria.docinhogelado.databinding.ProdutoItemBinding
import com.mentoria.docinhogelado.model.Produto

class ProdutoAdapter(
    private val context: Context,
    produtos: List<Produto> = emptyList()
) : RecyclerView.Adapter<ProdutoAdapter.ViewHolder>() {

    var valorTotalPedido = ""
    private val produtos = produtos.toMutableList()

    class ViewHolder(private val binding: ProdutoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun vincula(produto: Produto) {
            val nome = binding.tvNome
            nome.text = produto.nome
            val descricao = binding.tvDescricao
            descricao.text = produto.descricao
            val valor = binding.tvValor
            valor.text = produto.valor
            val imagem = binding.imageView
            imagem.load(produto.imagem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ProdutoItemBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = produtos[position]
        holder.vincula(produto)
        var quantidadeValue = 0
        val tvQuantidade = holder.itemView.findViewById<TextView>(R.id.tvQuantidade)
        val tvAumenta = holder.itemView.findViewById<TextView>(R.id.tvAumenta)
        val tvDiminui = holder.itemView.findViewById<TextView>(R.id.tvDiminui)

        tvAumenta.setOnClickListener {
            quantidadeValue++
            if (quantidadeValue > 0)
                tvQuantidade.text = quantidadeValue.toString()
            valorTotalPedido = modificaValorPedido(quantidadeValue.toString(), produto.valor)
        }

        tvDiminui.setOnClickListener {
            quantidadeValue--
            if (quantidadeValue > 0)
                tvQuantidade.text = quantidadeValue.toString()
            valorTotalPedido = modificaValorPedido(quantidadeValue.toString(), produto.valor)
        }
    }

    override fun getItemCount(): Int = produtos.size

    fun atualiza(produtos: List<Produto>) {
        this.produtos.clear()
        this.produtos.addAll(produtos)
        notifyDataSetChanged()
    }

    fun modificaValorPedido(quantidade: String, produtoValor: String): String {
        val quantidadeInt = quantidade.toInt()
        val valorFloat = produtoValor.toFloat()
        val valorTotal = quantidadeInt * valorFloat
        return valorTotal.toString()
    }
}