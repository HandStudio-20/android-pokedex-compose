package com.mhand.android.study.pokedex.repository

import com.mhand.android.study.pokedex.data.PokemonRemoteDataSource
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val pokemonRemoteDataSource: PokemonRemoteDataSource
) {
    suspend fun getAllPokemon(limit: Int, offset: Int) = pokemonRemoteDataSource.getAllPokemon(limit, offset)
    suspend fun getPokemonDetail(name: String) = pokemonRemoteDataSource.getPokemonDetail(name)
}