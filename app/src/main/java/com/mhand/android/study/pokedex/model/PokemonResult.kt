package com.mhand.android.study.pokedex.model

import com.google.gson.annotations.SerializedName

data class PokemonResult(
    @SerializedName("count")
    val count: Int,

    @SerializedName("results")
    val results: List<PokemonResultPair>
)

data class PokemonResultPair(
    @SerializedName("name")
    val name: String,

    @SerializedName("url")
    val url: String
)