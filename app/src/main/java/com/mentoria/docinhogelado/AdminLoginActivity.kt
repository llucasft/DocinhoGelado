package com.mentoria.docinhogelado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mentoria.docinhogelado.databinding.ActivityAdminLoginBinding

class AdminLoginActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityAdminLoginBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}