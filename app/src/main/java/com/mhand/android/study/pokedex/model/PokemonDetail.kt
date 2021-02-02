package com.mhand.android.study.pokedex.model

import com.google.gson.annotations.SerializedName

data class PokemonDetail(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("types")
    val types: List<PokemonTypeInfo>
) {
    val pokedexNumber: String
        get() = id.toString().padStart(3, '0')

    val imageResource: String
        get() = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/${pokedexNumber}.png"
}

data class PokemonTypeInfo(
    @SerializedName("slot")
    val slot: Int,

    @SerializedName("type")
    val type: PokemonType
)

data class PokemonType(
    @SerializedName("name")
    val name: String,

    @SerializedName("url")
    val url: String,
)