package com.example.rickandmorty.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NetworkClient {

    private const val BASE_URL = "https://rickandmortyapi.com/api/"





    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)

            .addConverterFactory(MoshiConverterFactory.create(moshi()))
            .build()
    }


    private fun moshi() =
        Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()


    val api: CharacterApi by lazy {
        retrofit.create(CharacterApi::class.java)
    }

}