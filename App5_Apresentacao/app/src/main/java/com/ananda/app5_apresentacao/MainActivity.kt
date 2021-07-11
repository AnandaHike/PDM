package com.ananda.app5_apresentacao

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

lateinit var btnSobre: Button
lateinit var btnFormacao: Button
lateinit var btnExperiencia: Button
lateinit var btnObjetivos: Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSobre = findViewById(R.id.btnSobre)
        btnFormacao = findViewById(R.id.btnFormacao)
        btnExperiencia = findViewById(R.id.btnExperiencia)
        btnObjetivos = findViewById(R.id.btnObjetivo)

        btnSobre.setOnClickListener() {
            val Sobre = Intent(this@MainActivity, Sobre::class.java)
            startActivity(Sobre)
        }

        btnFormacao.setOnClickListener() {
            val Formacao = Intent(this@MainActivity, Formacao::class.java)
            startActivity(Formacao)
        }

        btnExperiencia.setOnClickListener() {
            val Experiencia = Intent(this@MainActivity, Experiencia::class.java)
            startActivity(Experiencia)
        }

        btnObjetivos.setOnClickListener() {
            val Objetivos = Intent(this@MainActivity, Objetivo::class.java)
            startActivity(Objetivos)
        }

    }
}