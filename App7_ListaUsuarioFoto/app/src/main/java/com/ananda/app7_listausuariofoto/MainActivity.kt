package com.ananda.app7_listausuariofoto

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.rvUsuarios)

        val lista = mutableListOf<Usuario>(
            Usuario(nome="Ananda", email="nandabrunetti@hotmail.com", stack= Stack.FRONTEND, senioridade= Senioridade.JUNIOR, foto=resources.getDrawable(R.drawable.eu)),
            Usuario(nome="Magali", email="magahike.com", stack= Stack.BACKEND, senioridade= Senioridade.SENIOR, foto =resources.getDrawable(R.drawable.senior)),
            Usuario(nome = "Eduardo", email = "eduardo.com", stack = Stack.FULLSTACK, senioridade = Senioridade.PLENO, foto =resources.getDrawable(R.drawable.pleno))
        )

        rv.adapter = UsuarioAdapter(lista)

        // Exibe os itens em uma coluna única no padrão vertical
         rv.layoutManager = LinearLayoutManager(this)

        // Exibe os itens em uma coluna única no padrão horizontal
        // rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // Exibe os itens em uma tabela com x colunas
        // rv.layoutManager = GridLayoutManager(this, 2)

        // Exibe os itens em uma tabela porém as células são ajustadas automaticamente de acordo com o conteúdo (Google Keep, Pintrest)
         // rv.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)

    }
}
