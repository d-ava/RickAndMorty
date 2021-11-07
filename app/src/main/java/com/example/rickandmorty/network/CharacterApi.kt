package com.example.rickandmorty.network


import com.example.rickandmorty.model.RickAndMorty
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApi {

    @GET("character")
    suspend fun getCharacters(@Query("page")page:Int): Response<RickAndMorty>
}