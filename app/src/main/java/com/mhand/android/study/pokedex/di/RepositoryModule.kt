package com.mhand.android.study.pokedex.di

import com.mhand.android.study.pokedex.api.PokemonApi
import com.mhand.android.study.pokedex.data.PokemonRemoteDataSource
import com.mhand.android.study.pokedex.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providePokemonRepository(
        pokemonRemoteDataSource: PokemonRemoteDataSource
    ) = PokemonRepository(pokemonRemoteDataSource)
}