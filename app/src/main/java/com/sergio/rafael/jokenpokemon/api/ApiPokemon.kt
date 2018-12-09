package com.sergio.rafael.jokenpokemon.api

import com.sergio.rafael.jokenpokemon.model.Rank
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiPokemon{
    @GET("pontuacao")
    fun getRank(): Call<List<Rank>>

    @POST("pontuacao")
    fun registerRank(@Body rank: Rank): Call<Void>
}