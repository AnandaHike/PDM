package com.ananda.app16_listacomprasbd

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao

interface MercadoDAO {
    @Query("SELECT * FROM TB_MERCADO")
    suspend fun getMercado(): List<Mercado>

    @Insert
    suspend fun addMercado(t: Mercado)

    @Delete
    suspend fun deleteMercado(t: Mercado)

}