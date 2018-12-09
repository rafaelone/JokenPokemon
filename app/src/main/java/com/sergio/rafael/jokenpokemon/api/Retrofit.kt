package com.sergio.rafael.jokenpokemon.api

import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit<T> {

    fun getClient(c: Class<T>): T {
        val retrofit = Retrofit.Builder()
                .client(getOkhttpClientAuth().build())
                .baseUrl("https://gamestjd.herokuapp.com/jokenpokemon/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        return retrofit.create(c)
    }

}

fun getOkhttpClientAuth(): OkHttpClient.Builder{
    return OkHttpClient.Builder()
            //.addInterceptor(AuthInterceptor())
            .addNetworkInterceptor(StethoInterceptor())
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
}

fun getPokemonApi(): ApiPokemon {
    return Retrofit<ApiPokemon>().getClient(ApiPokemon::class.java)
}