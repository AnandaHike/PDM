package com.ananda.app18_consultacep

import retrofit2.Response
import retrofit2.http.*

interface CEPService {
    @GET("{cep}/json/")
    suspend fun buscarCEP(
        @Path("cep") cep: String
    ): Response <CEP>
}