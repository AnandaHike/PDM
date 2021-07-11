package com.ananda.app5_apresentacao

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Sobre : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sobre)

        lateinit var btnVoltar: Button

        btnVoltar = findViewById(R.id.btnVoltar)

        btnVoltar.setOnClickListener {
            val Voltar = Intent(
                this@Sobre,
                MainActivity::class.java
            )
            startActivity(Voltar)
        }
    }
}