package com.ananda.app16_listacomprasbd

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity(), MercadoAdapterListener {

    lateinit var mercadoAdapter: MercadoAdapter
    lateinit var edtMercado: EditText
    lateinit var btnIncluir: ImageButton
    lateinit var preferenciasMercado: SharedPreferences
    lateinit var rv: RecyclerView

    var db: AppDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        preferenciasMercado = getSharedPreferences("mercadoPreferences", Context.MODE_PRIVATE)

        rv = findViewById<RecyclerView>(R.id.rvMercado)

        btnIncluir = findViewById(R.id.btnIncluir)
        edtMercado = findViewById(R.id.edtMercado)

        btnIncluir.setOnClickListener() {
            if (edtMercado.text.toString().isNotEmpty()) {
                adicionarMercado(edtMercado.text.toString())
                edtMercado.text.clear()

                // Apagar a preferência gravada anteriormente
                val editor = preferenciasMercado.edit()
                editor.remove("NOME")
                editor.commit()
            } else {
                edtMercado.error = "Insira um texto válido!"
            }
        }
    }

    fun adicionarMercado(nomeMercado: String) {
        CoroutineScope(Dispatchers.IO).launch {
            db = DatabaseBuilder.getAppDatabase(this@MainActivity)

            db?.mercadoDao()?.addMercado(Mercado(nome = nomeMercado))

            val mercadoDao = db?.mercadoDao()

            val resposta = mercadoDao?.getMercado()

            withContext(Dispatchers.Main) {
                resposta?.let {
                    mercadoAdapter.refreshListMercado(resposta)
                }
            }
        }
    }

    fun recuperarLista(){

        CoroutineScope(Dispatchers.IO).launch {

            db = DatabaseBuilder.getAppDatabase(this@MainActivity)

            val tarefaDAO = db?.mercadoDao()

            val resposta = tarefaDAO?.getMercado()

            withContext(Dispatchers.Main){
                resposta?.let{
                    mercadoAdapter = MercadoAdapter(it, this@MainActivity)

                    rv.adapter = mercadoAdapter

                    rv.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()

        if (edtMercado.text.toString().isNotEmpty()){

            val editor = preferenciasMercado.edit()

            editor.putString("NOME", edtMercado.text.toString())

            editor.commit()
        }
    }

    // #Preferencias
    override fun onResume() {
        super.onResume()

        // Recupera (lê) uma preferência e utiliza ela populando um Edit Text
        edtMercado.setText(preferenciasMercado.getString("NOME", null))
    }

    override fun onStart() {
        super.onStart()

        recuperarLista()
    }

    override fun excluirMercado(mercado: Mercado) {
        CoroutineScope(Dispatchers.IO).launch {
            db = DatabaseBuilder.getAppDatabase(this@MainActivity)

            db?.mercadoDao()?.deleteMercado(mercado)

            val mercadoDao = db?.mercadoDao()

            val resposta = mercadoDao?.getMercado()

            withContext(Dispatchers.Main) {
                resposta?.let {
                    mercadoAdapter.refreshListMercado(resposta)

                    Toast.makeText(this@MainActivity, "Mercadoria excluída", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
