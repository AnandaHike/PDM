package com.ananda.app8_listapetfoto

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.rvUsuarios)

        val lista = mutableListOf<Pet>(
            Pet(nome="Lidina", descricao = "Gata siamesa porte médio - 3kg e 10 anos", genero = Genero.FEMEA, foto=resources.getDrawable(R.drawable.siames)),
            Pet(nome="Bolota", descricao = "Gato branco porte pequeno - 1,5kg e 2 anos", genero = Genero.MACHO, foto=resources.getDrawable(R.drawable.branco)),
            Pet(nome="Serafina", descricao = "Gata malhada porte médio - 3kg e 7 anos", genero = Genero.FEMEA, foto=resources.getDrawable(R.drawable.malhado))
        )

        rv.adapter = PetAdapter(lista)

        // Exibe os itens em uma coluna única no padrão vertical
        rv.layoutManager = LinearLayoutManager(this)

        // Exibe os itens em uma coluna única no padrão horizontal
        // rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // Exibe os itens em uma tabela com x colunas
        // rv.layoutManager = GridLayoutManager(this, 2)

        // Exibe os itens em uma tabela porém as células são ajustadas automaticamente de acordo com o conteúdo (Google Keep, Pintrest)
        // rv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

    }
}