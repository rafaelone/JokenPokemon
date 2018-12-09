package com.sergio.rafael.jokenpokemon.api

import com.sergio.rafael.jokenpokemon.model.Rank
import retrofit2.Call
import retrofit2.http.GET

interface ApiPokemon{
    @GET("pontuacao")
    fun getRank(): Call<List<Rank>>
}