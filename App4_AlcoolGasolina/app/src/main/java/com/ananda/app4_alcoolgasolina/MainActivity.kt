package com.ananda.app4_alcoolgasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var resultadoCalculo: TextView
    lateinit var botaoCalcular: Button
    var valorAlcool: Double = 0.00
    var valorGasolina: Double = 0.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultadoCalculo = findViewById(R.id.txtResultado)
        botaoCalcular = findViewById(R.id.btnCalcular)
        botaoCalcular.setOnClickListener {
            valorAlcool = findViewById<EditText>(R.id.txtValorAlcool).text.toString().toDouble()
            valorGasolina = findViewById<EditText>(R.id.txtValorGasolina).text.toString().toDouble()
            CalcularMelhorValor()
        }
    }

    fun CalcularMelhorValor(){

        var resultado = valorAlcool / valorGasolina

        if (resultado > 0.7){
            resultadoCalculo.setText("Melhor utilizar a gasolina!")
        }else if (resultado < 0.7){
            resultadoCalculo.setText("Melhor utilizar o alcool!")
        }else{
            resultadoCalculo.setText("Pode utilizar gasolina ou alcool!")
        }

    }
}