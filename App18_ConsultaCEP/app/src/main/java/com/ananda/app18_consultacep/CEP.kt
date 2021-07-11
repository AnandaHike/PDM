package com.ananda.app18_consultacep

import com.google.gson.annotations.SerializedName

data class CEP (
    @SerializedName("cep") var cep: String,
    @SerializedName("logradouro") val logradouro: String,
    @SerializedName("complemento") val complemento: String,
    @SerializedName("bairro") val bairro: String,
    @SerializedName("localidade") val localidade: String,
    @SerializedName("uf") val uf: String,
    @SerializedName("ibge") val ibge: Int,
    @SerializedName("gia") val gia: Int,
    @SerializedName("ddd") val ddd: Int,
    @SerializedName("siafi") val siafi: Int
    ){
    override fun toString(): String {
        return "CEP: $cep\nRua: $logradouro\nBairro: $bairro\nCidade: $localidade / $uf\n\nIBGE: $ibge\nGIA: $gia\nDDD: $ddd\nSIAFI: $siafi"
    }
}

