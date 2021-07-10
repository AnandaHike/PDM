package com.ananda.app16_listacomprasbd

import androidx.room.*

@Entity(tableName = "TB_MERCADO")
data class Mercado(
    @PrimaryKey(autoGenerate = true)
    var id: Int=0,
    @ColumnInfo(name="Nome")
    val nome: String,
    )
