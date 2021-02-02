package com.mhand.android.study.pokedex.api

import com.mhand.android.study.pokedex.model.Pokemon
import com.mhand.android.study.pokedex.model.PokemonDetail
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {

    @GET("pokemon")
    suspend fun getAllPokemon(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int
    ): List<Pokemon>

    @GET("pokemon/{id}")
    suspend fun getPokemonDetail(
        @Path("id") id: Int
    ): PokemonDetail
}