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
import com.mentoria.docinhogelado.util.ProdutoClickListener

class ProdutoAdapter(
    private val context: Context,
    private val itemClickListener: ProdutoClickListener,
    produtos: List<Produto> = emptyList(),
) : RecyclerView.Adapter<ProdutoAdapter.ViewHolder>() {

    var valorTotalPedido = ""
    private val produtos = produtos.toMutableList()

    class ViewHolder(private val binding: ProdutoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val tvAumenta = binding.tvAumenta
        val tvDiminui = binding.tvDiminui
        val tvQuantidade = binding.tvQuantidade

        fun vincula(produto: Produto) {
            val nome = binding.tvNome
            nome.text = produto.nome
            val descricao = binding.tvDescricao
            descricao.text = produto.descricao
            val valor = binding.tvValor
            valor.text = produto.valor
            val imagem = binding.imageView
            imagem.load(produto.imagem)
            tvQuantidade.text = produto.quantidade.toString()
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

        holder.tvAumenta.setOnClickListener {
            itemClickListener.aumenta(produtos[position], position)
        }

        holder.tvDiminui.setOnClickListener {
            itemClickListener.diminui(produtos[position], position)
        }
    }

    override fun getItemCount(): Int = produtos.size

    fun atualiza(produtos: List<Produto>) {
        this.produtos.clear()
        this.produtos.addAll(produtos)
        notifyDataSetChanged()
    }
}