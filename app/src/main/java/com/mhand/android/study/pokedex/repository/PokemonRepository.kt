package com.mhand.android.study.pokedex.repository

import com.mhand.android.study.pokedex.api.PokemonApi
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val pokemonApi: PokemonApi
) {
    suspend fun getAllPokemon(limit: Int, offset: Int) = pokemonApi.getAllPokemon(limit, offset)

    suspend fun getPokemonDetail(name: String) = pokemonApi.getPokemonDetail(name)
}