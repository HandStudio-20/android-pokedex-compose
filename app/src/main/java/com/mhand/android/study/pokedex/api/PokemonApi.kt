package com.mhand.android.study.pokedex.api

import com.mhand.android.study.pokedex.model.Pokemon
import com.mhand.android.study.pokedex.model.PokemonResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {

    @GET("pokemon")
    suspend fun getAllPokemon(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonResult

    @GET("pokemon/{name}")
    suspend fun getPokemonDetail(
        @Path("name") name: String
    ): Pokemon
}