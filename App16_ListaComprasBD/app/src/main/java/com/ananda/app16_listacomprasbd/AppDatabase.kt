package com.ananda.app16_listacomprasbd

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Mercado::class), version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun mercadoDao():MercadoDAO

    // Implementar aqui todos os DAOs que o App tiver daqui pra baixo...
}
