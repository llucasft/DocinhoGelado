package com.mentoria.docinhogelado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mentoria.docinhogelado.databinding.ActivityProdutosBinding

class ProdutosActivity : AppCompatActivity() {
    private val binding by lazy{
        ActivityProdutosBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}