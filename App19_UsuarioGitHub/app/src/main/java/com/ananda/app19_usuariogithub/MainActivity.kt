package com.ananda.app19_usuariogithub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

class MainActivity : AppCompatActivity() {

    lateinit var edtGit: EditText
    lateinit var txtGit: TextView
    lateinit var bntBuscarUsuario: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtGit = findViewById(R.id.edtGit)
        txtGit = findViewById(R.id.txtGit)
        bntBuscarUsuario = findViewById(R.id.btnBuscarUsuario)

        bntBuscarUsuario.setOnClickListener() {
            val login = edtGit.text.toString()
            if (login.isNotEmpty()) {
                buscarUsuario(login)
            } else {
                edtGit.error = "Digite um usuário válido!"
            }
        }
    }

    fun buscarUsuario(login: String){
        val retrofitClient = Network.retrofitConfig("https://api.github.com/users/")
        val servico = retrofitClient.create(GitHubService::class.java)

        CoroutineScope(IO).launch {
            try {
                val response = servico.buscarUsuario(login)

                withContext(Main){
                    delay(2000L)
                    if(response.isSuccessful){
                        txtGit.text = response.body().toString()
                    }
                }
            }catch (e: Exception){
                withContext(Main){
                    txtGit.text = "Não foi possível processar a sua solicitação."
                }
            }
        }
    }

}