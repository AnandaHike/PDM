package com.ananda.app6_cadastro

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Cliente(val nome: String, val idade: Int) : Parcelable