package com.mhand.android.study.pokedex.data

import com.mhand.android.study.pokedex.api.PokemonApi
import javax.inject.Inject

class PokemonRemoteDataSource @Inject constructor(
    private val pokemonApi: PokemonApi
) {
    suspend fun getAllPokemon(limit: Int, offset: Int) = pokemonApi.getAllPokemon(limit, offset)
    suspend fun getPokemonDetail(name: String) = pokemonApi.getPokemonDetail(name)
}