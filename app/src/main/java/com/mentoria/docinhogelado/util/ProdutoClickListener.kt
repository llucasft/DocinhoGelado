package com.mentoria.docinhogelado.util

import com.mentoria.docinhogelado.model.Produto

interface ProdutoClickListener {
    fun diminui(produto: Produto, position: Int){

    }
    fun aumenta(produto: Produto, position: Int){

    }
}