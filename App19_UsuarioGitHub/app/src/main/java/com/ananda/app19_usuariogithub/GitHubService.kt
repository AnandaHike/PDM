package com.ananda.app19_usuariogithub

import retrofit2.Response
import retrofit2.http.*

interface GitHubService {
    @GET("{login}")
    suspend fun buscarUsuario(
        @Path("login") login: String
    ): Response <GitHub>
}