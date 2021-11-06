package com.example.rickandmorty.network


import com.example.rickandmorty.model.RickAndMorty
import retrofit2.Response
import retrofit2.http.GET

interface CharacterApi {

    @GET("character")
    suspend fun getCharacters(): Response<RickAndMorty>
}