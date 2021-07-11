package com.ananda.app19_usuariogithub

import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat
import java.util.*

data class GitHub(
    @SerializedName("id") var id: Int,
    @SerializedName("login") val login: String,
    @SerializedName("html_url") val link: String,
    @SerializedName("name") val nome: String,
    @SerializedName("email") val email: String,
    @SerializedName("company") val empresa: String,
    @SerializedName("blog") val blog: String,
    @SerializedName("twitter_username") val twitter: String,
    @SerializedName("bio") val bio: String,
    @SerializedName("public_repos") val repo: String,
    @SerializedName("followers") val seguidores: Int,
    @SerializedName("following") val seguindo: Int,
    @SerializedName("updated_at") val atualizou: Date,
    @SerializedName("created_at") val criou: Date
){
    override fun toString(): String {
        val data1: String = SimpleDateFormat("dd/MM/yyyy").format(criou)
        println(data1)
        val data2: String = SimpleDateFormat("dd/MM/yyyy").format(atualizou)
        println(data2)

        return "ID: $id\nLogin: $login\nNome: $nome\n" +
               "Link GitHub: $link\nEmail: $email\nEmpresa: $empresa\n" +
               "Twitter: $twitter\nBlog: $blog\n" +
                "Biografia: $bio\nRepositórios públicos: $repo\nSeguidores: $seguidores\nSeguindo: $seguindo\nCriação do GitHub: $data1\nÚltima atualização: $data2"
    }
}

