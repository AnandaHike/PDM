package com.ananda.app18_consultacep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

class MainActivity : AppCompatActivity() {

    lateinit var edtCEP: EditText
    lateinit var txtCEP: TextView
    lateinit var bntBuscarCEP: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtCEP = findViewById(R.id.edtCEP)
        txtCEP = findViewById(R.id.txtCEP)
        bntBuscarCEP = findViewById(R.id.btnBuscarCEP)

        bntBuscarCEP.setOnClickListener() {
            val cep = edtCEP.text.toString()
            if (cep.isNotEmpty()) {
                buscarCEP(cep)
            } else {
                edtCEP.error = "Digite um CEP válido!"
            }
        }
    }

    fun buscarCEP(cep: String){
        val retrofitClient = Network.retrofitConfig("https://viacep.com.br/ws/")
        val servico = retrofitClient.create(CEPService::class.java)

        CoroutineScope(IO).launch {
            try {
                val response = servico.buscarCEP(cep.replace("-", ""))

                withContext(Main){
                    delay(2000L)
                    if(response.isSuccessful){
                        txtCEP.text = response.body().toString()
                    }
                }
            }catch (e: Exception){
                withContext(Main){
                    txtCEP.text = "Não foi possível processar a sua solicitação."
                }
            }
        }
    }

}