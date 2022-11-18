package com.mentoria.docinhogelado.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.mentoria.docinhogelado.databinding.ProdutoItemBinding
import com.mentoria.docinhogelado.model.Produto

class ProdutoAdapter(
    private val context: Context,
    produtos: List<Produto> = emptyList()
):RecyclerView.Adapter<ProdutoAdapter.ViewHolder>() {

    private val produtos = produtos.toMutableList()

    class ViewHolder(private val binding: ProdutoItemBinding): RecyclerView.ViewHolder(binding.root){

        fun vincula(produto: Produto) {
            val nome = binding.tvNome
            nome.text = produto.nome
            val descricao = binding.tvDescricao
            descricao.text = produto.descricao
            val valor = binding.tvValor
            valor.text = produto.valor
//            val aumenta = binding.tvAumenta
//            val diminui = binding.tvDiminui
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
    }

    override fun getItemCount(): Int = produtos.size

    fun atualiza(produtos: List<Produto>) {
        this.produtos.clear()
        this.produtos.addAll(produtos)
        notifyDataSetChanged()
    }
}