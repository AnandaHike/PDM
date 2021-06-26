package com.ananda.app8_listapetfoto

import android.graphics.drawable.Drawable

data class Pet(
    var foto: Drawable?=null,
    var nome: String,
    var descricao: String,
    var genero: Genero
)
