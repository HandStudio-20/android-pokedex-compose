package com.mhand.android.study.pokedex.model

import com.google.gson.annotations.SerializedName

data class Pokemon(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("types")
    val types: List<PokemonType>
) {
    val pokedexNumber: String
        get() = id.toString().padStart(3, '0')

    val imageResource: String
        get() = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/${pokedexNumber}.png"
}

data class PokemonType(
    @SerializedName("slot")
    val slot: Int,

    @SerializedName("type")
    val type: PokemonTypeInfo
)

data class PokemonTypeInfo(
    @SerializedName("name")
    val name: String,

    @SerializedName("url")
    val url: String,
)