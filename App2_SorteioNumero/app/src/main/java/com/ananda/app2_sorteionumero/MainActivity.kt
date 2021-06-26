package com.ananda.app2_sorteionumero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var botaoSortear: Button
    lateinit var texto: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botaoSortear = findViewById(R.id.bntSortear)
        botaoSortear.setOnClickListener{
            texto = findViewById(R.id.txtNumero)
            SortearNumero()
        }
    }

    fun SortearNumero(){

        var numeroSorteado = Random().nextInt(11)

        texto.setText("O número é: $numeroSorteado")
    }
}
