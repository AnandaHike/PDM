package com.ananda.app11_cadastrotarefafoto

import android.graphics.Bitmap
import android.graphics.drawable.Drawable

data class Tarefas(
    var foto: Bitmap?=null,
    var titulo: String,
    var descricao: String,
    var diasemana: DiaSemana,
    var dificuldade: Dificuldade,
    var obrigatorio: Boolean
)
