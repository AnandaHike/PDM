package com.ananda.app18_consultacep

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {
    companion object{
        fun retrofitConfig(pathBaseURL: String): Retrofit{
            return Retrofit.Builder()
                .baseUrl(pathBaseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}
