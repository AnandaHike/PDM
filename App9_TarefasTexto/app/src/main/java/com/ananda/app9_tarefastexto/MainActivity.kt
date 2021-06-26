package com.ananda.app9_tarefastexto

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.rvUsuarios)

        val lista = mutableListOf<Tarefas>(
            Tarefas(descricao="Comprar abacaxi", foto=resources.getDrawable(R.drawable.supermercado)),
            Tarefas(descricao="Comprar carne, bolacha, leite, pipoca, leite condensado e creme de leite", foto=resources.getDrawable(R.drawable.supermercado)),
            Tarefas(descricao="Fazer compras"),
            Tarefas(descricao="Fazer compras")


            )

        rv.adapter = TarefaAdapter(lista)

        // Exibe os itens em uma coluna única no padrão vertical
        // rv.layoutManager = LinearLayoutManager(this)

        // Exibe os itens em uma coluna única no padrão horizontal
        // rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // Exibe os itens em uma tabela com x colunas
        // rv.layoutManager = GridLayoutManager(this, 2)

        // Exibe os itens em uma tabela porém as células são ajustadas automaticamente de acordo com o conteúdo (Google Keep, Pintrest)
        rv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

    }
}