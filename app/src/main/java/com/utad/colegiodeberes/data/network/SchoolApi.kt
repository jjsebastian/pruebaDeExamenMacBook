package com.utad.colegiodeberes.data.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * necesito
 *  -añadir permisos internet
 *  -servicio
 *  -Las respuestas de la api parseadas para el service
 */

object SchoolApi {
    private val interceptor = HttpLoggingInterceptor().apply{
        level = HttpLoggingInterceptor.Level.BODY
    }
    private val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://ud5-server.onrender.com/api/v1/") // TODO poner url de la API El url base siempre debe acabar en /
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: SchoolService by lazy {
        retrofit.create(SchoolService::class.java)
    }
}