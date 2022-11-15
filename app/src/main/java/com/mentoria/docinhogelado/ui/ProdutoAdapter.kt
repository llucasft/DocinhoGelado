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
    produtos: List<Produto>
):RecyclerView.Adapter<ProdutoAdapter.ViewHolder>() {

    private val produtos = produtos.toMutableList()

    class ViewHolder(private val binding: ProdutoItemBinding): RecyclerView.ViewHolder(binding.root){
        private val nome = binding.tvNome
        private val descricao = binding.tvDescricao
        private val valor = binding.tvValor
        private val quantidade = binding.tvQuantidade
        private val aumenta = binding.tvAumenta
        private val diminui = binding.tvDiminui
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
    }

    override fun getItemCount(): Int = produtos.size
}